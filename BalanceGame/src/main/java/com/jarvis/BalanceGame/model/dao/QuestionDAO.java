package com.jarvis.BalanceGame.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;

@Repository
public class QuestionDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 승인된 전체 문제 조회
	private static final String SELECTALL_APPROVED_QUESTIONlIST = "SELECT Q.QUESTION_ID, Q.TITLE, Q.QUESTION_DATE, COUNT(DISTINCT W.LOGIN_ID) AS LIKE_COUNT,\r\n"
			+ "IFNULL(W.WISH_ID, 0) AS USER_LIKED FROM QUESTION Q LEFT JOIN WISH W ON W.QUESTION_ID = Q.QUESTION_ID AND W.LOGIN_ID = ?\r\n"
			+ "WHERE Q.QUESTION_ACCESS = 'T' GROUP BY Q.QUESTION_ID, Q.TITLE, Q.QUESTION_DATE";

	// 크롤링한 문제 조회
	private static final String SELECTALL_CRAWLLING = "SELECT Q.QID, Q.TITLE, Q.WRITER, Q.ANSWER_A, Q.ANSWER_B , EXPLANATION FROM QUESTIONS Q";

	// 관리자가 사용하는 승인한 전체 문제 조회
	private static final String SELECTALL_ADMIN_APPROVED_QUESTIONS = "SELECT Q.QUESTION_ID, Q.TITLE, Q.WRITER Q.EXPLANATION Q.QUESTION_DATE FROM QUESTIONS Q WHERE QUESTION_ACCESS = 'T' ";

	// 관리자가 사용하는 승인하지 않은 전체 문제 조회
	private static final String SELECTALL_ADMIN_UNAPPROVED_QUESTIONS = "SELECT Q.QUESTION_ID, Q.TITLE, Q.WRITER, Q.EXPLANATION, Q.QUESTION_DATE FROM QUESTIONS Q WHERE QUESTION_ACCESS = 'F' ";

	// 문제 개수
	private static final String SELECT_CNT = "SELECT COUNT(1) AS CNT FROM QUESTIONS WHERE QUESTION_ACCESS=?";
	
	// 사용자가 풀 문제를 랜덤으로 조회
	private static final String SELECT_ONE_RANDOM = "SELECT IFNULL(W.WISH_ID, 0) AS LIKE_ID, Q.QUESTION_ID, Q.TITLE, Q.ANSWER_A, Q.ANSWER_B, Q.WRITER, Q.EXPLANATION, QUESTION_DATE FROM \r\n"
			+ " (SELECT QUESTION_ID, TITLE, ANSWER_A, ANSWER_B, WRITER, EXPLANATION, QUESTION_DATE FROM QUESTIONS WHERE Q.QUESTION_ACCESS = 'T' ORDER BY RAND()) Q\r\n"
			+ " LEFT OUTER JOIN WISH W ON Q.QUESTION_ID = W.QUESTION_ID AND W.LOGIN_ID = ? LIMIT = 1 ";


	// 문제 상세보기 
	private static final String SELECT_ONE_DETAIL = "SELECT Q.QUESTION_ID, Q.TITLE, Q.ANSWER_A, Q.ANSWER_B, Q.EXPLANATION, Q.WRITER Q.QUESTION_DATE "
			+ "COUNT(CASE WHEN A.ANSWER = 'A' THEN 1 END) AS COUNT_A, "
			+ "COUNT(CASE WHEN A.ANSWER = 'B' THEN 1 END) AS COUNT_B, "
			+ "IFNULL(W.WISH_ID, 0) AS LIKE_ID "
			+ "FROM QUESTIONS Q JOIN ANSWERS A ON Q.QUESTION_ID = A.QUESTION_ID "
			+ "LEFT JOIN WISH W ON Q.QUESTION_ID = W.QUESTION_ID AND W.LOGIN_ID = ? WHERE Q.QUESTION_ID=? "
			+ "GROUP BY Q.QUESTION_ID, Q.WRITER, Q.TITLE, Q.ANSWER_A, Q.ANSWER_B, Q.EXPLANATION, W.WISH_ID, Q.QUESTION_DATE";

	// 관리자가 사용하는 문제 상세보기 
	private static final String SELECT_ONE_ADMIN = "SELECT QUESTION_ID, TITLE, WRITER, ANSWER_A, ANSWER_B, EXPLANATION, QUESTION_DATE, FROM QUESTIONS Q WHERE QUESTION_ID = ? ";
	
	// 사용자가 질문 생성
	private static final String INSERT = "INSERT INTO QUESTIONS (WRITER, TITLE, ANSWER_A, ANSWER_B, EXPLANATION) VALUES(?,?,?,?,?)";
	
	// 관리자가 질문 생성
	private static final String INSERT_ADMIN = "INSERT INTO QUESTIONS (WRITER, TITLE, ANSWER_A, ANSWER_B, EXPLANATION, QUESTION_ACCESS) VALUES(?,?,?,?,?,'T')";

	// 관리자가 문제 수정
	private static final String UPDATE = "UPDATE QUESTIONS SET TITLE=?,ANSWER_A=?,ANSWER_B=?,EXPLANATION=?, Q_ACCESS=? WHERE QID=?";

	// 관리자가 문제 승인
	private static final String UPDATE_ACCESS = "UPDATE QUESTIONS SET Q_ACCESS='T' WHERE QID=?";
	
	// 관리자가 문제 삭제 
	private static final String DELETE = "DELETE FROM QUESTIONS WHERE QID=?";

	public List<QuestionDTO> selectAll(QuestionDTO qDTO) {

		// 문제 모두 조회
		if (qDTO.getSearchCondition().equals("viewAllOfQuestionList")) {
			Object[] args = { qDTO.getWriter() };
			return jdbcTemplate.query(SELECTALL_APPROVED_QUESTIONlIST, args, new QuestionRowMapperList());
		}
		// 크롤링 문제조회
		else if (qDTO.getSearchCondition().equals("crawling")) {
			System.out.println("로그 qDAO: 크롤링");
			return jdbcTemplate.query(SELECTALL_CRAWLLING, new QuestionRowMapper());
		}
		// 관리자가 승인한 문제조회
		else if (qDTO.getSearchCondition().equals("adminViewAllOfApprovedQuestions")) {
			return jdbcTemplate.query(SELECTALL_ADMIN_APPROVED_QUESTIONS, new QuestionRowMapper());
		}
		// 관리자가 승인하지 않은 문제조회
		else if (qDTO.getSearchCondition().equals("adminViewAllOfUnapprovedQuestions")) {
			return jdbcTemplate.query(SELECTALL_ADMIN_UNAPPROVED_QUESTIONS, new QuestionRowMapper());
		}
		return null;
	}

	// 가져올 문제테이블의 정보를 무작위로 정렬해서 가져와서 맨위에 있는 한개의 행의 데이터만 조회
	public QuestionDTO selectOne(QuestionDTO qDTO) {
		
		// 문제 상세보기
		if (qDTO.getSearchCondition().equals("questionDetail")) {
			Object[] args = { qDTO.getWriter(), qDTO.getQuestionId() };
			return jdbcTemplate.queryForObject(SELECT_ONE_DETAIL, args, new QuestionRowMapperDetail());
		} 
		
		// 문제 랜덤으로 보기 
		else if (qDTO.getSearchCondition().equals("showRandomQuestion")) {
			Object[] args = { qDTO.getWriter() };
			return jdbcTemplate.queryForObject(SELECT_ONE_RANDOM, args, new QuestionRowMapperShowToUser());
		} 
		
		// 관리자가 문제 상세보기 
		else if (qDTO.getSearchCondition().equals("adminQuestionDetail")) {
			Object[] args = { qDTO.getQuestionId() };
			return jdbcTemplate.queryForObject(SELECT_ONE_ADMIN, args, new QuestionRowMapper());
		}
		return null;
	}

	public boolean insert(QuestionDTO qDTO) {
		int result = 0;
		if (qDTO.getSearchCondition().equals("createQuestionUser")) {
			result = jdbcTemplate.update(INSERT, qDTO.getWriter(), qDTO.getTitle(), qDTO.getAnswerA(),
					qDTO.getAnswerB(), qDTO.getExplanation());
			if (result <= 0) {
				return false;
			}
		} else if (qDTO.getSearchCondition().equals("createQuestionAdmin")) {
			result = jdbcTemplate.update(INSERT_ADMIN, qDTO.getWriter(), qDTO.getTitle(), qDTO.getAnswerA(),
					qDTO.getAnswerB(), qDTO.getExplanation());
			if (result <= 0) {
				return false;
			}
		}
		return true;
	}

	public boolean update(QuestionDTO qDTO) {

		int result = 0;
		if (qDTO.getSearchCondition().equals("updateQuestion")) {
			result = jdbcTemplate.update(UPDATE, qDTO.getTitle(), qDTO.getAnswerA(), qDTO.getAnswerB(),
					qDTO.getExplanation());
			if (result <= 0) {
				return false;
			}
		} else if (qDTO.getSearchCondition().equals("approveQuestion")) {
			result = jdbcTemplate.update(UPDATE_ACCESS, qDTO.getQuestionId());
			if (result <= 0) {
				return false;
			}
		}
		return true;
	}

	public boolean delete(QuestionDTO qDTO) {
		int result = jdbcTemplate.update(DELETE, qDTO.getQuestionId());
		if (result <= 0) {
			return false;
		}
		return true;
	}
}

class QuestionRowMapperList implements RowMapper<QuestionDTO> {
	@Override
	public QuestionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		QuestionDTO data = new QuestionDTO();
		data.setQuestionId(rs.getInt("QUESTION_ID"));
		data.setTitle(rs.getString("TITLE"));
		data.setLikeCount(rs.getInt("LIKE_COUNT"));
		data.setLikeID(rs.getInt("LIKE_ID"));
		data.setQuestionDate(rs.getDate("QUESTION_DATE"));
		return data;
	}
}

class QuestionRowMapper implements RowMapper<QuestionDTO> {

	@Override
	public QuestionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		QuestionDTO data = new QuestionDTO();
		data.setQuestionId(rs.getInt("QUESTION_ID "));
		data.setTitle(rs.getString("TITLE"));
		data.setWriter(rs.getString("WRITER"));
		data.setExplanation(rs.getString("EXPLANATION"));
		data.setQuestionDate(rs.getDate("QUESTION_DATE"));
		return data;
	}
}

class QuestionRowMapperDetail implements RowMapper<QuestionDTO> {

	@Override
	public QuestionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		QuestionDTO data = new QuestionDTO();
		data.setQuestionId(rs.getInt("QUESTION_ID"));
		data.setWriter(rs.getString("WRITER"));
		data.setTitle(rs.getString("TITLE"));
		data.setAnswerA(rs.getString("ANSWER_A"));
		data.setAnswerB(rs.getString("ANSWER_B"));
		data.setExplanation(rs.getString("EXPLANATION"));
		data.setAnswerACount(rs.getInt("COUNT_A"));
		data.setAnswerBCount(rs.getInt("COUNT_B"));
		data.setLikeID(rs.getInt("LIKE_ID"));
		data.setQuestionDate(rs.getDate("QUESTION_DATE"));
		return data;
	}
}

class QuestionRowMapperShowToUser implements RowMapper<QuestionDTO> {

	@Override
	public QuestionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		QuestionDTO data = new QuestionDTO();
		data.setQuestionId(rs.getInt("QUESTION_ID"));
		data.setTitle(rs.getString("TITLE"));
		data.setWriter(rs.getString("WRITER"));
		data.setAnswerA(rs.getString("ANSWER_A"));
		data.setAnswerB(rs.getString("ANSWER_B"));
		data.setExplanation(rs.getString("EXPLANATION"));
		data.setLikeID(rs.getInt("LIKE_ID"));
		data.setQuestionDate(rs.getDate("QUESTION_DATE"));
		return data;
	}
}
