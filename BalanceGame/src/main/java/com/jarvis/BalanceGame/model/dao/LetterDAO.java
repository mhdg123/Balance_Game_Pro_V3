package com.jarvis.BalanceGame.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jarvis.BalanceGame.model.dto.LetterDTO;

@Repository
public class LetterDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 전체 편지함 조회
	private static final String SELECTALL = "SELECT LETTER_ID, SENDER, TITLE, LETTER_CONTENTS, LETTER_DATE, LETTER_STATUS FROM LETTER";
	
	// 안읽은 편지 조회
	private static final String SELECTALL_UNREAD = "SELECT LETTER_ID, TITLE, SENDER FROM LETTER WHERE LETTER_STATUS = 'F' AND LOGIN_ID=?";
	
	// 해당 메세지 조회 
	private static final String SELECTONE = "SELECT SENDER, TITLE, LETTER_CONTENTS, LETTER_DATE FROM LETTER WHERE LETTER_ID = ?";
	
	// 메세지 발송 
	private static final String INSERT = "INSERT INTO LETTER(SENDER, LOGIN_ID, TITLE, LETTER_CONTENTS, LETTER_STATUS, LETTER_DATE) VALUES (?,?,?,?,'F',NOW())";
	
	// 메세지 읽음 유무 
	private static final String UPDATE = "UPDATE LETTER SET LETTER_STATUS = CASE WHEN LETTER_STATUS = 'F' THEN 'T' ELSE 'F' END WHERE LETTER_ID = ?";
	
	// 메세지 삭제 
	private static final String DELETE = "DELETE FROM LETTER WHERE LETTER_ID = ?";
	
	
	public List<LetterDTO> selectAll(LetterDTO lDTO){
		
		List<LetterDTO> datas = null;
		if(lDTO.getSearchCondition().equals("unReadMessage")) {
			Object[] args = {lDTO.getLoginId()};
			datas = jdbcTemplate.query(SELECTALL_UNREAD, args, new UnReadLetterRowMapper());
		}
		else if(lDTO.getSearchCondition().equals("viewAllMessage")) {
			datas = jdbcTemplate.query(SELECTALL, new LetterRowMapper());
		}
		return datas;
	}
	
	public LetterDTO selectOne(LetterDTO lDTO) {
		LetterDTO data = null;
		Object[] args= {lDTO.getLetterId()};
		try {
			data = jdbcTemplate.queryForObject(SELECTONE, args, new LetterRowMapperViewOne());	
		} catch (Exception e) {
			System.out.println("해당 편지 데이터가 없습니다");
		}
		return data;
	}
	
	public boolean insert(LetterDTO lDTO) {
		int result = jdbcTemplate.update(INSERT, lDTO.getSender(), lDTO.getLoginId(), lDTO.getTitle(), lDTO.getLetterContents());
		if(result<=0) {
			return false;
		}
		return true;
	}
	public boolean update(LetterDTO lDTO) {
		int result = jdbcTemplate.update(UPDATE, lDTO.getLetterId());
		if(result <=0 ) {
			return false;
		}
		return true;
	}
	public boolean delete(LetterDTO lDTO) {
		int result = jdbcTemplate.update(DELETE, lDTO.getLetterId());
		if(result <=0) {
			return false;
		}
		return true;
	}
}

class UnReadLetterRowMapper implements RowMapper<LetterDTO>{

	@Override
	public LetterDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		LetterDTO data = new LetterDTO();
		data.setLetterId(rs.getInt("LETTER_ID"));
		data.setSender(rs.getString("SENDER"));
		data.setTitle(rs.getString("TITLE"));
		return data;
	}
}

class LetterRowMapper implements RowMapper<LetterDTO>{

	@Override
	public LetterDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		LetterDTO data = new LetterDTO();
		data.setLetterId(rs.getInt("LETTER_ID"));
		data.setSender(rs.getString("SENDER"));
		data.setLoginId(rs.getString("LOGIN_ID"));
		data.setTitle(rs.getString("TITLE"));
		data.setLetterContents(rs.getString("LETTER_CONTENTS"));
		data.setLetterDate(rs.getDate("LETTER_DATE"));
		data.setLetterStatus(rs.getString("LETTER_STATUS"));
		return data;
	}
}

class LetterRowMapperViewOne implements RowMapper<LetterDTO>{

	@Override
	public LetterDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		LetterDTO data = new LetterDTO();
		data.setSender(rs.getString("SENDER"));
		data.setTitle(rs.getString("TITLE"));
		data.setLetterContents(rs.getString("LETTER_CONTENTS"));
		data.setLetterDate(rs.getDate("LETTER_DATE"));
		return data;
	}
}

