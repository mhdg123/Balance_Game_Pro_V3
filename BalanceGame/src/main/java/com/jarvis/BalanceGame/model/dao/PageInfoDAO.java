package com.jarvis.BalanceGame.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jarvis.BalanceGame.model.dto.CommentDTO;
import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.PageInfoDTO;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;

@Repository
public class PageInfoDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 문제목록 (회원)
	private static final String SELECTALL_QUESTION = "SELECT Q.QUESTION_ID, Q.TITLE, Q.QUESTION_DATE, "
			+ "COUNT(DISTINCT W.LOGIN_ID) AS LIKE_COUNT, "
			+ "MAX(CASE WHEN W.LOGIN_ID = ? THEN 1 ELSE 0 END) AS LIKE_ID\r\n"
			+ "FROM QUESTION Q LEFT JOIN WISH W ON W.QUESTION_ID = Q.QUESTION_ID "
			+ "WHERE Q.QUESTION_ACCESS = 'T' GROUP BY Q.QUESTION_ID, Q.TITLE, Q.QUESTION_DATE\r\n" + "LIMIT ?, ?";

	// 문제목록 (관리자가 사용하는 승인한 전체 문제 조회)
	private static final String SELECTALL_ADMIN_APPROVED_QUESTIONS = "SELECT Q.QUESTION_ID, Q.TITLE, Q.WRITER, Q.EXPLANATION, Q.QUESTION_DATE FROM QUESTION Q WHERE QUESTION_ACCESS = 'T' "
			+ "ORDER BY Q.QUESTION_ID DESC LIMIT ?, ?";

	// 문제목록 (관리자가 사용하는 승인하지 않은 전체 문제 조회)
	private static final String SELECTALL_ADMIN_UNAPPROVED_QUESTIONS = "SELECT Q.QUESTION_ID, Q.TITLE, Q.WRITER, Q.EXPLANATION, Q.QUESTION_DATE FROM QUESTION Q WHERE QUESTION_ACCESS = 'F' "
			+ "ORDER BY Q.QUESTION_ID DESC LIMIT ?, ?";

	// 회원 랭킹 (포인트로 조회)
	private static final String SELECTALL_RANKING_USER = "SELECT M.LOGIN_ID, M.NICKNAME, IFNULL(TRUNCATE(SUM(P.AMOUNT/10), 1),0) AS TOTAL, CASE WHEN IFNULL(SUM(P.AMOUNT/10), 0) = 0 THEN NULL \r\n"
			+ "ELSE CAST(RANK() OVER (ORDER BY IFNULL(SUM(P.AMOUNT/10), 0) DESC, MIN(P.PAYMENT_DATE)) AS CHAR) \r\n"
			+ "END AS RANKING FROM MEMBER M LEFT JOIN PAYMENT P ON M.LOGIN_ID = P.LOGIN_ID GROUP BY M.NICKNAME, M.LOGIN_ID "
			+ "HAVING TOTAL > 0 LIMIT ?,?";

	// 회원 랭킹 (결제금액 후원순으로 조회)
	private static final String SELECTALL_RANKING_ADMIN = "SELECT M.LOGIN_ID, M.NICKNAME, MAX(P.PAYMENT_DATE) AS PAYMENT_DATE, IFNULL(SUM(P.AMOUNT), 0) AS TOTAL, "
			+ "CASE WHEN IFNULL(SUM(P.AMOUNT), 0) = 0 THEN NULL "
			+ "ELSE CAST(RANK() OVER (ORDER BY IFNULL(SUM(P.AMOUNT), 0) DESC, MIN(P.PAYMENT_DATE)) AS CHAR) "
			+ "END AS RANKING FROM MEMBER M LEFT JOIN PAYMENT P ON M.LOGIN_ID = P.LOGIN_ID GROUP BY M.NICKNAME, M.LOGIN_ID "
			+ "HAVING TOTAL > 0 LIMIT ?, ?";
	
	// 회원 랭킹 (결제금액 최신순으로 조회)
	private static final String SELECTALL_LATEST_ADMIN ="SELECT M.LOGIN_ID, M.NICKNAME, P.PAYMENT_DATE, P.AMOUNT\r\n"
			+ "FROM MEMBER M\r\n"
			+ "LEFT JOIN PAYMENT P ON M.LOGIN_ID = P.LOGIN_ID\r\n"
			+ "WHERE P.AMOUNT > 0\r\n"
			+ "ORDER BY P.PAYMENT_DATE DESC LIMIT ?, ?";
	
	// 회원 목록
	private static final String SELECTALL_MEMBER_LIST = "SELECT M.LOGIN_ID, M.GENDER, M.AGE, M.ADDRESS, M.EMAIL, IFNULL(SUM(P.AMOUNT), 0) AS TOTAL,\r\n"
			+ "CASE WHEN IFNULL(SUM(P.AMOUNT), 0) = 0 THEN NULL ELSE CAST(RANK() OVER (ORDER BY IFNULL(SUM(P.AMOUNT), 0) DESC, MIN(P.PAYMENT_DATE)) AS CHAR) \r\n"
			+ "END AS RANKING FROM MEMBER M LEFT JOIN PAYMENT P ON M.LOGIN_ID = P.LOGIN_ID GROUP BY M.LOGIN_ID, \r\n"
			+ "M.GENDER, M.AGE, M.ADDRESS, M.EMAIL LIMIT ?, ?";

	// 쪽지 목록 (회원)
	private static final String SELECTALL_LETTER_LIST = "SELECT LETTER_ID, SENDER, TITLE, LETTER_CONTENTS, LETTER_DATE, "
			+ "LETTER_STATUS FROM LETTER WHERE LOGIN_ID=? ORDER BY LETTER_DATE DESC LIMIT ?, ?";

	// 쪽지 목록 (관리자 - 건의사항)
	private static final String SELECTALL_LETTER_LIST_SUGGESTION = "SELECT LETTER_ID, SENDER, TITLE, LETTER_CONTENTS, LETTER_DATE, LETTER_STATUS "
			+ "FROM LETTER L JOIN MEMBER M ON L.LOGIN_ID = M.ROLE WHERE M.LOGIN_ID= ? AND LETTER_TYPE='SUGGESTION' "
			+ "ORDER BY LETTER_DATE DESC LIMIT ?, ?";

	// 쪽지 목록 (관리자 - 신고)
	private static final String SELECTALL_LETTER_LIST_REPORT = "SELECT LETTER_ID, TITLE, LETTER_STATUS, LETTER_DATE "
			+ "FROM LETTER L JOIN MEMBER M ON L.LOGIN_ID = M.ROLE WHERE M.LOGIN_ID= ? AND LETTER_TYPE='REPORT' "
			+ "ORDER BY LETTER_DATE DESC LIMIT ?, ?";

	// 안 읽은 쪽지 목록 (관리자 - 건의사항)
	private static final String SELECTALL_UNREAD_LETTER_LIST_SUGGESTION = "SELECT LETTER_ID, SENDER, TITLE, LETTER_CONTENTS, LETTER_DATE, LETTER_STATUS \r\n"
			+ "FROM LETTER L JOIN MEMBER M ON L.LOGIN_ID=M.ROLE WHERE M.LOGIN_ID= ? AND LETTER_STATUS = 'F' "
			+ "AND LETTER_TYPE = 'SUGGESTION'ORDER BY LETTER_DATE DESC LIMIT ?, ?";

	// 안 읽은 쪽지 목록 (회원)
	private static final String SELECTALL_UNREAD_LETTER_LIST = "SELECT LETTER_ID, TITLE, SENDER, LETTER_STATUS, LETTER_DATE "
			+ "FROM LETTER WHERE LETTER_STATUS = 'F' AND LOGIN_ID=? ORDER BY LETTER_DATE DESC LIMIT ?, ?";

	// 문제에 대한 댓글 목록
	private static final String SELECTALL_COMMENTS_OF_QUESTION = "SELECT C.COMMENT_ID, C.QUESTION_ID, M.LOGIN_ID, C.COMMENTS, C.COMMENT_DATE, M.NAME, M.GRADE "
			+ "FROM COMMENT C LEFT OUTER JOIN MEMBER M ON C.LOGIN_ID = M.LOGIN_ID "
			+ "WHERE C.QUESTION_ID=? ORDER BY C.COMMENT_DATE DESC LIMIT ?, ?";

	// 회원이 작성한 댓글 전체 출력
	private static final String SELECTALL_COMMENTS_OF_MEMBER = "SELECT C.COMMENT_ID, C.QUESTION_ID, C.LOGIN_ID, C.COMMENTS, C.COMMENT_DATE, M.NAME, M.GRADE "
			+ "FROM COMMENT C LEFT OUTER JOIN MEMBER M ON C.LOGIN_ID =M.LOGIN_ID WHERE C.LOGIN_ID=? "
			+ "ORDER BY C.COMMENT_DATE DESC LIMIT ?, ?";

	public List<PageInfoDTO> selectAll(PageInfoDTO pDTO) {
		List<PageInfoDTO> datas = null;

		// 문제 리스트 (회원)
		if (pDTO.getSearchCondition().equals("viewAllOfQuestionList")) {
			Object[] args = { pDTO.getLoginId(), pDTO.getOffset(), pDTO.getPasingnationSize() };
			datas = jdbcTemplate.query(SELECTALL_QUESTION, args, new PageInfoRowMapperQuestion());
		}
		// 문제 리스트 (관리자 - 승인한 문제)
		else if (pDTO.getSearchCondition().equals("adminViewAllOfApprovedQuestions")) {
			Object[] args = { pDTO.getOffset(), pDTO.getPasingnationSize() };
			datas = jdbcTemplate.query(SELECTALL_ADMIN_APPROVED_QUESTIONS, args, new PageInfoRowMapperQuestionAdmin());
		}
		// 문제 리스트 (관리자 - 승인하지 않은 문제)
		else if (pDTO.getSearchCondition().equals("adminViewAllOfUnapprovedQuestions")) {
			Object[] args = { pDTO.getOffset(), pDTO.getPasingnationSize() };
			datas = jdbcTemplate.query(SELECTALL_ADMIN_UNAPPROVED_QUESTIONS, args, new PageInfoRowMapperQuestionAdmin());
		}
		// 랭킹(회원)
		else if (pDTO.getSearchCondition().equals("rankingPoint")) {
			Object[] args = { pDTO.getOffset(), pDTO.getPasingnationSize() };
			datas = jdbcTemplate.query(SELECTALL_RANKING_USER, args, new PageInfoRowMapperRanking());
		}
		// 랭킹(관리자)
		else if (pDTO.getSearchCondition().equals("ranking")) {
			Object[] args = { pDTO.getOffset(), pDTO.getPasingnationSize() };
			datas = jdbcTemplate.query(SELECTALL_RANKING_ADMIN, args, new PageInfoRowMapperRankingAdmin());
		}
		else if (pDTO.getSearchCondition().equals("latest")) {
			Object[] args = { pDTO.getOffset(), pDTO.getPasingnationSize() };
			datas = jdbcTemplate.query(SELECTALL_LATEST_ADMIN, args, new PageInfoRowMapperLatestAdmin());
		}
		// 회원 리스트
		else if (pDTO.getSearchCondition().equals("viewAllOfMemberList")) {
			Object[] args = { pDTO.getOffset(), pDTO.getPasingnationSize() };
			datas = jdbcTemplate.query(SELECTALL_MEMBER_LIST, args, new PageInfoRowMapperMember());
		}
		// 쪽지 리스트(회원)
		else if (pDTO.getSearchCondition().equals("viewAllMessage")) {
			System.out.println("쪽지리스트" + pDTO);
			Object[] args = { pDTO.getLoginId(), pDTO.getOffset(), pDTO.getPasingnationSize() };
			datas = jdbcTemplate.query(SELECTALL_LETTER_LIST, args, new PageInfoRowMapperLetter());
		}
		// 쪽지 리스트(관리자 - 건의사항)
		else if (pDTO.getSearchCondition().equals("viewAllSuggestionMessageAdmin")) {
			Object[] args = { pDTO.getLoginId(), pDTO.getOffset(), pDTO.getPasingnationSize() };
			datas = jdbcTemplate.query(SELECTALL_LETTER_LIST_SUGGESTION, args, new PageInfoRowMapperLetter());
		}
		// 쪽지 리스트(관리자 - 신고)
		else if (pDTO.getSearchCondition().equals("viewAllReportMessageAdmin")) {
			Object[] args = { pDTO.getLoginId(), pDTO.getOffset(), pDTO.getPasingnationSize() };
			datas = jdbcTemplate.query(SELECTALL_LETTER_LIST_REPORT, args, new PageInfoRowMapperReportLetter());
		}
		// 쪽지 리스트(관리자 - 건의사항 안읽음)
		else if (pDTO.getSearchCondition().equals("unReadMessageAdmin")) {
			Object[] args = { pDTO.getLoginId(), pDTO.getOffset(), pDTO.getPasingnationSize() };
			datas = jdbcTemplate.query(SELECTALL_UNREAD_LETTER_LIST_SUGGESTION, args, new PageInfoRowMapperLetter());
		}
		// 쪽지 리스트(회원 - 안읽음)
		else if (pDTO.getSearchCondition().equals("unReadMessageMember")) {
			Object[] args = { pDTO.getLoginId(), pDTO.getOffset(), pDTO.getPasingnationSize() };
			datas = jdbcTemplate.query(SELECTALL_UNREAD_LETTER_LIST, args, new PageInfoRowMapperLetter());
		}
		// 해당 문제에 대한 댓글 전체 출력
		else if (pDTO.getSearchCondition().equals("questionComments")) {
			Object[] args = { pDTO.getQuestionId(), pDTO.getOffset(), pDTO.getPasingnationSize() };
			datas = jdbcTemplate.query(SELECTALL_COMMENTS_OF_QUESTION, args, new PageInfoRowMapperComments());
		}
		// 회원이 작성한 댓글 전체 출력
		else if (pDTO.getSearchCondition().equals("userComments")) {
			Object[] args = { pDTO.getLoginId(), pDTO.getOffset(), pDTO.getPasingnationSize() };
			datas = jdbcTemplate.query(SELECTALL_COMMENTS_OF_MEMBER, args, new PageInfoRowMapperComments());
		}
		return datas;
	}

	// 토탈 페이지 계산
	public int calcTotalPages(PageInfoDTO pDTO) {
		if (pDTO.getTotalRows() <= 0) { // 데이터가 없다면
			pDTO.setTotalPages(0); // 토탈페이지는 0
		}
		pDTO.setTotalPages(pDTO.getTotalRows() / pDTO.getPasingnationSize()); // 토탈 페이지 개수
		if (pDTO.getTotalRows()>10 && pDTO.getTotalRows() % pDTO.getPasingnationSize() > 0) { // 토탈 페이지 계산했을 때 나머지가 0보다 크다면
			pDTO.setTotalPages(pDTO.getTotalPages() + 1); // 페이지 개수 1 증가
		}
		return pDTO.getTotalPages();
	}

	// 페이지 번호에 따른 offset 계산
	public int calculateOffset(PageInfoDTO pDTO) {
		pDTO.setOffset((pDTO.getCurrentPage() - 1) * pDTO.getPasingnationSize());
		return pDTO.getOffset();
	}
}

class PageInfoRowMapperQuestion implements RowMapper<PageInfoDTO> {

	@Override
	public PageInfoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PageInfoDTO data = new PageInfoDTO();
		data.setQuestionId(rs.getInt("QUESTION_ID"));
		data.setTitle(rs.getString("TITLE"));
		data.setLikeCount(rs.getInt("LIKE_COUNT"));
		data.setWishId(rs.getInt("LIKE_ID"));
		data.setQuestionDate(rs.getDate("QUESTION_DATE"));
		return data;
	}
}

class PageInfoRowMapperQuestionAdmin implements RowMapper<PageInfoDTO> {

	@Override
	public PageInfoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PageInfoDTO data = new PageInfoDTO();
		data.setQuestionId(rs.getInt("QUESTION_ID"));
		data.setTitle(rs.getString("TITLE"));
		data.setWriter(rs.getString("WRITER"));
		data.setExplanation(rs.getString("EXPLANATION"));
		data.setQuestionDate(rs.getDate("QUESTION_DATE"));
		return data;
	}
}

class PageInfoRowMapperRankingAdmin implements RowMapper<PageInfoDTO> {

	@Override
	public PageInfoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PageInfoDTO data = new PageInfoDTO();
		data.setLoginId(rs.getString("LOGIN_ID"));
		data.setNickName(rs.getString("NICKNAME"));
		data.setTotal(rs.getInt("TOTAL"));
		data.setRanking(rs.getInt("RANKING"));
		data.setPaymentDate(rs.getDate("PAYMENT_DATE"));
		return data;
	}
}

class PageInfoRowMapperLatestAdmin implements RowMapper<PageInfoDTO> {

	@Override
	public PageInfoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PageInfoDTO data = new PageInfoDTO();
		data.setLoginId(rs.getString("LOGIN_ID"));
		data.setNickName(rs.getString("NICKNAME"));
		data.setPaymentAmount(rs.getInt("AMOUNT"));
		data.setPaymentDate(rs.getDate("PAYMENT_DATE"));
		return data;
	}
}

class PageInfoRowMapperRanking implements RowMapper<PageInfoDTO> {

	@Override
	public PageInfoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PageInfoDTO data = new PageInfoDTO();
		data.setLoginId(rs.getString("LOGIN_ID"));
		data.setNickName(rs.getString("NICKNAME"));
		data.setTotal(rs.getInt("TOTAL"));
		data.setRanking(rs.getInt("RANKING"));
		return data;
	}
}

class PageInfoRowMapperMember implements RowMapper<PageInfoDTO> {

	@Override
	public PageInfoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PageInfoDTO data = new PageInfoDTO();
		data.setLoginId(rs.getString("LOGIN_ID"));
		data.setAge(rs.getString("AGE"));
		data.setGender(rs.getString("GENDER"));
		data.setTotal(rs.getInt("TOTAL"));
		data.setRanking(rs.getInt("RANKING"));
		data.setAddress(rs.getString("ADDRESS"));
		data.setEmail(rs.getString("EMAIL"));
		return data;
	}
}

class PageInfoRowMapperLetter implements RowMapper<PageInfoDTO> {

	@Override
	public PageInfoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PageInfoDTO data = new PageInfoDTO();
		data.setLetterId(rs.getInt("LETTER_ID"));
		data.setSender(rs.getString("SENDER"));
		data.setTitle(rs.getString("TITLE"));
		data.setLetterDate(rs.getDate("LETTER_DATE"));
		data.setLetterStatus(rs.getString("LETTER_STATUS"));
		return data;
	}
}

class PageInfoRowMapperReportLetter implements RowMapper<PageInfoDTO> {

	@Override
	public PageInfoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PageInfoDTO data = new PageInfoDTO();
		data.setLetterId(rs.getInt("LETTER_ID"));
		data.setTitle(rs.getString("TITLE"));
		data.setLetterDate(rs.getDate("LETTER_DATE"));
		data.setLetterStatus(rs.getString("LETTER_STATUS"));
		return data;
	}
}

class PageInfoRowMapperComments implements RowMapper<PageInfoDTO> {

	@Override
	public PageInfoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PageInfoDTO data = new PageInfoDTO();
		data.setQuestionId(rs.getInt("QUESTION_ID"));
		data.setCommentId(rs.getInt("COMMENT_ID"));
		data.setLoginId(rs.getString("LOGIN_ID"));
		data.setComments(rs.getString("COMMENTS"));
		data.setMemberGrade(rs.getInt("GRADE"));
		data.setCommentDate(rs.getDate("COMMENT_DATE"));
		return data;
	}
}