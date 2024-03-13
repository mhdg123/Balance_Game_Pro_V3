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

	private static final String SELECTALL_APPROVED_QUESTIONlIST = "SELECT Q.QID, Q.TITLE, COALESCE(S.SID, 0) AS QUESTIONLIKEID FROM QUESTION Q LEFT OUTER JOIN "
			+ "SAVE S ON S.QID = Q.QID AND S.LOGIN_ID = ? WHERE Q.Q_ACCESS = 'T' ";

	private static final String SELECTALL_FALSE = "SELECT Q.QID,Q.TITLE,C.CATEGORY \r\n" + "FROM QUESTIONS Q\r\n"
			+ "JOIN CATEGORY C ON Q.CATEGORY =C.CGID\r\n" + "WHERE Q_ACCESS='F'";

	private static final String SELECTALL_CRAWLLING = "SELECT Q.QID, Q.TITLE, Q.WRITER, Q.ANSWER_A, Q.ANSWER_B , EXPLANATION FROM QUESTIONS Q";

	private static final String SELECTALL_ADMIN_APPROVED_QUESTIONS = "SELECT Q.QID, Q.TITLE, Q.WRITER, Q.ANSWER_A, Q.ANSWER_B, EXPLANATION, REG_DATE FROM QUESTIONS Q WHERE Q_ACCESS = 'T' ";

	private static final String SELECTALL_ADMIN_UNAPPROVED_QUESTIONS = "SELECT Q.QID, Q.TITLE, Q.WRITER, Q.ANSWER_A, Q.ANSWER_B, EXPLANATION, REG_DATE FROM QUESTIONS Q WHERE Q_ACCESS = 'F' ";

	// 질문생성 SQL
	private static final String INSERT = "INSERT INTO QUESTIONS (QID, WRITER, TITLE, ANSWER_A, ANSWER_B, EXPLANATION) VALUES((SELECT NVL(MAX(QID),0) + 1 FROM QUESTIONS),?,?,?,?,?)";

	private static final String INSERT_ADMIN = "INSERT INTO QUESTIONS (QID, WRITER, TITLE, ANSWER_A, ANSWER_B, EXPLANATION,CATEGORY,Q_ACCESS) \r\n"
			+ "VALUES((SELECT NVL(MAX(QID),0) + 1 FROM QUESTIONS),?,?,?,?,?,?,'T')";

	private static final String SELECT_ONE_RANDOM = "SELECT COALESCE(S.SID, 0) AS SAVE_SID,\r\n"
			+ "       Q.QID, Q.TITLE, Q.ANSWER_A, Q.ANSWER_B, Q.WRITER, Q.EXPLANATION, C.CATEGORY\r\n" + "FROM \r\n"
			+ "    (SELECT QID,TITLE,ANSWER_A,ANSWER_B,WRITER,EXPLANATION,CATEGORY,Q_ACCESS FROM QUESTIONS ORDER BY DBMS_RANDOM.VALUE) Q\r\n"
			+ "LEFT OUTER JOIN \r\n" + "    CATEGORY C ON Q.CATEGORY = C.CGID\r\n" + "LEFT OUTER JOIN\r\n"
			+ "    SAVE S ON S.QID = Q.QID AND S.LOGIN_ID = ?\r\n" + "WHERE ROWNUM = 1 AND  Q.Q_ACCESS = 'T'";

	private static final String SELECT_ONE_DETAIL = "SELECT Q.QID,Q.TITLE,Q.ANSWER_A,Q.ANSWER_B,Q.EXPLANATION, "
			+ "COUNT(CASE WHEN A.ANSWER = 'A' THEN 1 END) AS COUNT_A, "
			+ "COUNT(CASE WHEN A.ANSWER = 'B' THEN 1 END) AS COUNT_B, NVL(S.SID, 0) AS SAVE_SID "
			+ "FROM QUESTIONS Q JOIN ANSWERS A ON A.QID=Q.QID "
			+ "LEFT JOIN SAVE S ON S.QID = Q.QID AND S.LOGIN_ID = ? WHERE Q.QID=? "
			+ "GROUP BY Q.QID, Q.TITLE, Q.ANSWER_A, Q.ANSWER_B, Q.EXPLANATION, S.SID";

	private static final String SELECT_ONE_ADMIN = "SELECT QID, TITLE, WRITER, ANSWER_A, ANSWER_B, EXPLANATION, CATEGORY, REG_DATE, Q_ACCESS FROM QUESTIONS Q WHERE Qid = ? ";

	private static final String UPDATE = "UPDATE QUESTIONS \r\n"
			+ "SET TITLE=?,ANSWER_A=?,ANSWER_B=?,EXPLANATION=?,CATEGORY=?,Q_ACCESS=? \r\n" + "WHERE QID=?";

	private static final String UPDATE_ACCESS = "UPDATE QUESTIONS SET Q_ACCESS='T' WHERE QID=?";
	private static final String DELETE = "DELETE FROM QUESTIONS WHERE QID=?";

	public List<QuestionDTO> selectAll(QuestionDTO qDTO) {

		// 문제 모두 조회
		if (qDTO.getSearchCondition().equals("viewAllOfQuestionList")) {
			Object[] args = { qDTO.getLoginId() };
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
		if (qDTO.getSearchCondition().equals("questionDetail")) {
			Object[] args = { qDTO.getLoginId(), qDTO.getQuestionId() };
			return jdbcTemplate.queryForObject(SELECT_ONE_DETAIL, args, new QuestionRowMapperDetail());
		} else if (qDTO.getSearchCondition().equals("showRandomQuestion")) {
			Object[] args = { qDTO.getLoginId() };
			return jdbcTemplate.queryForObject(SELECT_ONE_RANDOM, args, new QuestionRowMapperShowToUser());
		} else if (qDTO.getSearchCondition().equals("adminQuestionDetail")) {
			Object[] args = { qDTO.getQuestionId() };
			return jdbcTemplate.queryForObject(SELECT_ONE_ADMIN, args, new QuestionRowMapper());
		}
		return null;
	}

	public boolean insert(QuestionDTO qDTO) {
		int result = 0;
		if (qDTO.getSearchCondition().equals("createQuestionUser")) {
			result = jdbcTemplate.update(INSERT, qDTO.getLoginId(), qDTO.getTitle(), qDTO.getAnswerA(),
					qDTO.getAnswerB(), qDTO.getExplanation());
			if (result <= 0) {
				return false;
			}
		} else if (qDTO.getSearchCondition().equals("createQuestionAdmin")) {
			result = jdbcTemplate.update(INSERT_ADMIN, qDTO.getLoginId(), qDTO.getTitle(), qDTO.getAnswerA(),
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
		data.setQuestionLikeID(rs.getInt("QUESTIONLIKEID"));
		return data;
	}
}

class QuestionRowMapper implements RowMapper<QuestionDTO> {

	@Override
	public QuestionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		QuestionDTO data = new QuestionDTO();
		data.setAnswerA(rs.getString("ANSWER_A"));
		data.setAnswerB(rs.getString("ANSWER_B"));
		data.setQuestionId(rs.getInt("QUESTION_ID "));
		data.setTitle(rs.getString("TITLE"));
		data.setLoginId(rs.getString("LOGIN_ID"));
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
		data.setTitle(rs.getString("TITLE"));
		data.setAnswerA(rs.getString("ANSWER_A"));
		data.setAnswerB(rs.getString("ANSWER_B"));
		data.setExplanation(rs.getString("EXPLANATION"));
		data.setAnswerACount(rs.getInt("COUNT_A"));
		data.setAnswerBCount(rs.getInt("COUNT_B"));
		data.setQuestionLikeID(rs.getInt("QUESTIONLIKEID"));
		return data;
	}
}

class QuestionRowMapperShowToUser implements RowMapper<QuestionDTO> {

	@Override
	public QuestionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		QuestionDTO data = new QuestionDTO();
		data.setQuestionId(rs.getInt("QUESTION_ID"));
		data.setLoginId(rs.getString("LOGIN_ID"));
		data.setTitle(rs.getString("TITLE"));
		data.setAnswerA(rs.getString("ANSWER_A"));
		data.setAnswerB(rs.getString("ANSWER_B"));
		data.setExplanation(rs.getString("EXPLANATION"));
		data.setQuestionLikeID(rs.getInt("QUESTIONLIKEID"));
		return data;
	}
}
