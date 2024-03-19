package com.jarvis.BalanceGame.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jarvis.BalanceGame.model.dto.CommentDTO;

@Repository
public class CommentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 해당 문제에 대한 댓글 전체출력 
	private static final String SELECTALL_QUESTION = "SELECT C.COMMENT_ID, C.QUESTION_ID, M.LOGIN_ID, C.COMMENTS, C.COMMENT_DATE, M.NAME\r\n"
			+ "FROM COMMENT C LEFT OUTER JOIN MEMBER M ON C.LOGIN_ID = M.LOGIN_ID WHERE C.QUESTION_ID=?";

	// 회원이 작성한 모든 댓글 출력 
	private static final String SELECTALL_MEMBER = "SELECT C.COMMENT_ID, C.QUESTION_ID, C.LOGIN_ID, C.COMMENTS, C.COMMENT_DATE, M.NAME\r\n"
			+ "FROM COMMENT C LEFT OUTER JOIN MEMBER M ON C.LOGIN_ID =M.LOGIN_ID WHERE C.LOGIN_ID=?";

	// 댓글 작성 
	private static final String INSERT = "INSERT INTO COMMENTS(QUESTION_ID, LOGIN_ID, COMMENTS) VALUES (?,?,?)";

	// 댓글 전체 출력하기
	public List<CommentDTO> selectAll(CommentDTO cDTO) {

		List<CommentDTO> datas = null;
		// 질문에 대한 댓글
		if (cDTO.getSearchCondition().equals("questionComments")) {
			Object[] args = { cDTO.getQuestionId() };
			datas = jdbcTemplate.query(SELECTALL_QUESTION, args, new CommentRowMapper());
		}
		// 유저에 대한 댓글
		else if (cDTO.getSearchCondition().equals("userComments")) {
			Object[] args = { cDTO.getLoginId() };
			datas = jdbcTemplate.query(SELECTALL_MEMBER, args, new CommentRowMapper());
		}
		return datas;
	}

	private CommentDTO selectOne(CommentDTO cDTO) {
		return null;
	}

	// 댓글 추가하기
	public boolean insert(CommentDTO cDTO) {
		int result = 0;
		if (cDTO.getSearchCondition().equals("createComments")) {
			result = jdbcTemplate.update(INSERT, cDTO.getQuestionId(), cDTO.getLoginId(), cDTO.getComments());
		}
		if (result <= 0) {
			return false;
		}
		return true;
	}

	public boolean update(CommentDTO cDTO) {
		if (cDTO.getSearchCondition().equals("댓글수정")) {
			// 모델
		} else if (cDTO.getSearchCondition().equals("회원탈퇴")) {
			// 모델
		}

		return false;
	}

	public boolean delete(CommentDTO cDTO) {
		// 댓글 삭제
		return false;
	}

}

class CommentRowMapper implements RowMapper<CommentDTO> {

	@Override
	public CommentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CommentDTO data = new CommentDTO();
		data.setQuestionId(rs.getInt("QUESTION_ID"));
		data.setCommentId(rs.getInt("COMMENT_ID"));
		data.setLoginId(rs.getString("LOGIN_ID"));
		data.setComments(rs.getString("COMMENTS"));
		data.setCommentDate(rs.getDate("COMMENT_DATE"));
		return data;
	}

}
