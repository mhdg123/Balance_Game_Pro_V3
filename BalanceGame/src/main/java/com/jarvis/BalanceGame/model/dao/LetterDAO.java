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
	
	// 안읽은 편지 조회
	private static final String SELECTALL_UNREAD = "SELECT LETTER_ID, TITLE, SENDER, LETTER_STATUS, LETTER_DATE FROM LETTER WHERE LETTER_STATUS = 'F' AND LOGIN_ID=?";
	
	// 총 편지 수 (관리자)
	private static final String SELECTONE_CNT_ADMIN = "SELECT COUNT(1) AS CNT FROM LETTER WHERE LETTER_TYPE=? ";
	
	// 총 편지 수 (회원)
	private static final String SELECTONE_CNT_MEMBER = "SELECT COUNT(1) AS CNT FROM LETTER";
	
	// 해당 회원 총 편지 수
	private static final String SELECTONE_CNT_MEMBERONE = "SELECT COUNT(1) AS CNT FROM LETTER WHERE LOGIN_ID = ?";
	
	// 해당 메세지 조회
	private static final String SELECTONE = "SELECT LETTER_ID,SENDER,LOGIN_ID  ,TITLE, LETTER_CONTENTS, LETTER_DATE, LETTER_STATUS FROM LETTER WHERE LETTER_ID = ?";

	// 메세지 발송(관리자)
	private static final String INSERT = "INSERT INTO LETTER(SENDER, LOGIN_ID, TITLE, LETTER_CONTENTS) VALUES (?,?,?,?)";
	
	// 메세지 발송(회원)
	private static final String INSERT_SUGGESTION = "INSERT INTO LETTER (SENDER, LOGIN_ID, TITLE, LETTER_CONTENTS, LETTER_TYPE) VALUES(?,?,?,?,'SUGGESTION')";
	
	// 메세지 읽음 유무
	private static final String UPDATE = "UPDATE LETTER SET LETTER_STATUS = CASE WHEN LETTER_STATUS = 'F' THEN 'T' ELSE 'F' END WHERE LETTER_ID = ?";

	// 메세지 읽음 처리
	private static final String UPDATE_ALL_READ = "UPDATE LETTER SET LETTER_STATUS = 'T' WHERE LETTER_ID = ?";
	
	// 메세지 안읽음 처리 
	private static final String UPDATE_ALL_UNREAD = "UPDATE LETTER SET LETTER_STATUS = 'F' WHERE LETTER_ID =?";
	
	// 메세지 삭제
	private static final String DELETE = "DELETE FROM LETTER WHERE LETTER_ID = ?";

	public List<LetterDTO> selectAll(LetterDTO lDTO) {

		List<LetterDTO> datas = null;
		// 총 메세지 수(관리자)
		if (lDTO.getSearchCondition().equals("unreadMemberMessage")) {
			
			Object[] args = { lDTO.getLoginId() };
			datas = jdbcTemplate.query(SELECTALL_UNREAD, args, new LetterRowMapper());
			System.out.println("datas  "+datas);
		}
		return datas;
	}

	public LetterDTO selectOne(LetterDTO lDTO) {
		LetterDTO data = null;
		System.out.println("편지 PK id값 DAO: " + lDTO.getLetterId());
		try {
			if(lDTO.getSearchCondition().equals("viewOneMessage")) {
				Object[] args = { lDTO.getLetterId() };
				data = jdbcTemplate.queryForObject(SELECTONE, args, new LetterRowMapperViewOne());
			}
			// 총 메세지 수(관리자)
			else if(lDTO.getSearchCondition().equals("messageCntAdmin")) {
				Object[] args = { lDTO.getLetterType() };
				data = jdbcTemplate.queryForObject(SELECTONE_CNT_ADMIN, args, new LetterRowMapperCnt());
			}
			// 총 메세지 수(회원)
			else if(lDTO.getSearchCondition().equals("messageCntMember")) {
				data = jdbcTemplate.queryForObject(SELECTONE_CNT_MEMBER, new LetterRowMapperCnt());
			}
			else if(lDTO.getSearchCondition().equals("messageCntMemberOne")) {
				System.out.println(lDTO+"<<<<<<<<<,DAO");
				Object[] args = {lDTO.getLoginId()};
				data = jdbcTemplate.queryForObject(SELECTONE_CNT_MEMBERONE,args, new LetterRowMapperCnt());
			}
			
		} catch (Exception e) {
			System.out.println("해당 편지 데이터가 없습니다");
		}
		return data;
	}

	public boolean insert(LetterDTO lDTO) {
		int result =0;
		// 관리자 쪽지 발송
		if(lDTO.getSearchCondition().equals("writeLetterAdmin")) {
			result = jdbcTemplate.update(INSERT, lDTO.getSender(), lDTO.getLoginId(), lDTO.getTitle(), lDTO.getLetterContents());
		}
		// 회원 쪽지 발송
		else if(lDTO.getSearchCondition().equals("writeLetterMember")) {
			result = jdbcTemplate.update(INSERT_SUGGESTION, lDTO.getSender(), lDTO.getLoginId(), lDTO.getTitle(), lDTO.getLetterContents());
		}
		if (result <= 0) {
			return false;
		}
		return true;
	}

	public boolean update(LetterDTO lDTO) {
		int result =0;
		if(lDTO.getSearchCondition().equals("updateReadStatus")) {
			result = jdbcTemplate.update(UPDATE, lDTO.getLetterId());
		}
		else if(lDTO.getSearchCondition().equals("updateAllRead")) {
			result = jdbcTemplate.update(UPDATE_ALL_READ, lDTO.getLetterId());
		}
		else if(lDTO.getSearchCondition().equals("updateAllUnRead")) {
			result = jdbcTemplate.update(UPDATE_ALL_UNREAD, lDTO.getLetterId());
		}
		
		if (result <= 0) {
			return false;
		}
		return true;
	}

	public boolean delete(LetterDTO lDTO) {
		int result = jdbcTemplate.update(DELETE, lDTO.getLetterId());
		if (result <= 0) {
			return false;
		}
		return true;
	}
}

class LetterRowMapper implements RowMapper<LetterDTO> {

	@Override
	public LetterDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		LetterDTO data = new LetterDTO();
		data.setLetterId(rs.getInt("LETTER_ID"));
		data.setSender(rs.getString("SENDER"));
		data.setTitle(rs.getString("TITLE"));
		data.setLetterDate(rs.getDate("LETTER_DATE"));
		data.setLetterStatus(rs.getString("LETTER_STATUS"));
		return data;
	}
}


class LetterRowMapperViewOne implements RowMapper<LetterDTO> {

	@Override
	public LetterDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		LetterDTO data = new LetterDTO();
		data.setLetterId(rs.getInt("LETTER_ID")); // 추가 필요
		data.setLoginId(rs.getString("LOGIN_ID"));
		data.setSender(rs.getString("SENDER"));
		data.setTitle(rs.getString("TITLE"));
		data.setLetterContents(rs.getString("LETTER_CONTENTS"));
		data.setLetterDate(rs.getDate("LETTER_DATE"));
		data.setLetterStatus(rs.getString("LETTER_STATUS"));
		return data;
	}
}

class LetterRowMapperCnt implements RowMapper<LetterDTO>{

	@Override
	public LetterDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		LetterDTO data = new LetterDTO();
		data.setCnt(rs.getInt("CNT"));
		return data;
	}
	
}
