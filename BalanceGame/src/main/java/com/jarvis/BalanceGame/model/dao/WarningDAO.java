package com.jarvis.BalanceGame.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jarvis.BalanceGame.model.dto.WarningDTO;


@Repository
public class WarningDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECTALL = null;
	
	private static final String SELECTONE = "SELECT COMMENT_ID FROM WARNING WHERE REPORTER = ? AND COMMENT_ID = ?";
	
	private static final String INSERT = "INSERT INTO WARNING (COMMENT_WRITER,REPORTER, COMMENT_ID) VALUES (?, ?, ?)";
	
	private static final String UPDATE = null;
	
	private static final String DELETE = "DELETE FROM WARNING WHERE COMMENT_ID = ?";
	
	
	public WarningDTO selectOne(WarningDTO wDTO) {
		WarningDTO data = null;
		WarningDTO reSet = new WarningDTO();
		Object[] args = {wDTO.getRepoter(), wDTO.getCommentId()};
		try {
			data = jdbcTemplate.queryForObject(SELECTONE, args, new WarningRowMapperIsData());
		} catch (Exception e) {
			System.out.println("경고테이블에 맞는 데이터가 없습니다");
			return reSet;
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

class WarningRowMapperIsData implements RowMapper<WarningDTO>{

	@Override
	public WarningDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		WarningDTO data = new WarningDTO();
		data.setCommentId(rs.getInt("COMMENT_ID"));
		return data;
	}
}

