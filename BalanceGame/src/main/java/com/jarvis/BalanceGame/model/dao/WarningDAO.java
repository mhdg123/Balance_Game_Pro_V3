package com.jarvis.BalanceGame.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.model.dto.WarningDTO;


@Repository
public class WarningDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 신고 당한사람의 총 댓글 조회
	private static final String SELECTALL = "SELECT W.REPORTER, W.COMMENT_WRITER, W.COMMENT_ID, W.WARNING_DATE, C.COMMENTS\r\n"
			+ "FROM WARNING W "
			+ "JOIN COMMENT C ON W.COMMENT_ID = C.COMMENT_ID "
			+ "WHERE W.COMMENT_WRITER = ?";
	
	// 신고 중복 방지(기존 신고자 조회)
	private static final String SELECTONE = "SELECT COMMENT_ID FROM WARNING WHERE REPORTER = ? AND COMMENT_ID = ?";
	
	// 신고하기
	private static final String INSERT = "INSERT INTO WARNING (COMMENT_WRITER,REPORTER, COMMENT_ID) VALUES (?, ?, ?)";
	
	private static final String UPDATE = null;
	
	// 신고 해제하기 
	private static final String DELETE = "DELETE FROM WARNING WHERE COMMENT_ID = ?";
	
	
	public List<WarningDTO> selectAll(WarningDTO wDTO) {
		List<WarningDTO> datas = null;
		if(wDTO.getSearchCondition().equals("reportedComments")) {
			Object[] args = { wDTO.getCommentWriter() };
			datas = jdbcTemplate.query(SELECTALL, args, new WarningRowMapperUser());
		}
		return datas;
	}
	
	public WarningDTO selectOne(WarningDTO wDTO) {
		WarningDTO data = null;
		Object[] args = {wDTO.getRepoter(), wDTO.getCommentId()};
		try {
			data = jdbcTemplate.queryForObject(SELECTONE, args, new WarningRowMapperIsData());
		} catch (Exception e) {
			System.out.println("경고테이블에 맞는 데이터가 없습니다");
		}
		return data;
	}
	
	public boolean insert(WarningDTO wDTO){
		int result = jdbcTemplate.update(INSERT, wDTO.getCommentWriter(), wDTO.getRepoter(), wDTO.getCommentId());
		if(result<=0) {
			return false;
		}
		return true;
	}
	
	public boolean delete(WarningDTO wDTO) {
		int result = jdbcTemplate.update(DELETE, wDTO.getCommentId());
		if(result<=0) {
			return false;
		}
		return true;
	}
}

// 3번 신고당한 유저
class WarningRowMapperUser implements RowMapper<WarningDTO> {

	@Override
	public WarningDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		WarningDTO data = new WarningDTO();
		data.setRepoter(rs.getString("REPORTER"));
		data.setCommentId(rs.getInt("COMMENT_ID"));
		data.setWarningDate(rs.getDate("WARNING_DATE"));
		data.setRepoter(rs.getString("COMMENT_WRITER"));
		data.setComments(rs.getString("COMMENTS"));
		return data;
	}
}


class WarningRowMapperIsData implements RowMapper<WarningDTO>{

	@Override
	public WarningDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		WarningDTO data = new WarningDTO();
		data.setCommentId(rs.getInt("COMMENT_ID"));
		return data;
	}
}

