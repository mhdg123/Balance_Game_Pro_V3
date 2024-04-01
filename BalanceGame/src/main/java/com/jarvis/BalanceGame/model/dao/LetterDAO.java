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
	private static final String SELECTALL = "SELECT LETTER_ID, SENDER, TITLE, LETTER_CONTENTS, LETTER_DATE, LETTER_STATUS FROM LETTER WHERE LOGIN_ID=? ORDER BY LETTER_DATE DESC";

	// 전체 편지함 조회(관리자 - 건의사항)
	private static final String SELECTALL_ADMIN_SUGGESTION = "SELECT LETTER_ID, SENDER, TITLE, LETTER_CONTENTS, LETTER_DATE, LETTER_STATUS \r\n"
			+ "FROM LETTER L JOIN MEMBER M ON L.LOGIN_ID = M.ROLE WHERE M.LOGIN_ID= ? AND LETTER_TYPE='SUGGESTION'\r\n"
			+ "ORDER BY LETTER_DATE DESC";
	
	// 전체 편지함 조회(관리자 - 신고)
	private static final String SELECTALL_ADMIN_REPORT = "SELECT LETTER_ID, TITLE, LETTER_STATUS, LETTER_DATE "
			+ "FROM LETTER L JOIN MEMBER M ON L.LOGIN_ID = M.ROLE WHERE M.LOGIN_ID= ? AND LETTER_TYPE='REPORT' "
			+ "ORDER BY LETTER_DATE DESC";
	
	// 안읽은 편지 조회
	private static final String SELECTALL_UNREAD = "SELECT LETTER_ID, TITLE, SENDER, LETTER_STATUS, LETTER_DATE FROM LETTER WHERE LETTER_STATUS = 'F' AND LOGIN_ID=?";

	// 안읽은 편지 조회(관리자)
	private static final String SELECTALL_UNREAD_ADMIN = "SELECT LETTER_ID, SENDER, TITLE, LETTER_CONTENTS, LETTER_DATE, LETTER_STATUS "
			+ "FROM LETTER L JOIN MEMBER M ON L.LOGIN_ID=M.ROLE WHERE M.LOGIN_ID= ? AND LETTER_STATUS = 'F' ORDER BY LETTER_DATE DESC";
	
	
	// 해당 메세지 조회
	private static final String SELECTONE = "SELECT LETTER_ID,SENDER, TITLE, LETTER_CONTENTS, LETTER_DATE, LETTER_STATUS FROM LETTER WHERE LETTER_ID = ?";

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
		Object[] args = { lDTO.getLoginId() };
		if (lDTO.getSearchCondition().equals("unReadMessage")) {
			datas = jdbcTemplate.query(SELECTALL_UNREAD, args, new LetterRowMapper());
		} 
		else if(lDTO.getSearchCondition().equals("unReadMessageAdmin")) {
			datas = jdbcTemplate.query(SELECTALL_UNREAD_ADMIN, args, new LetterRowMapper());
		}
		else if (lDTO.getSearchCondition().equals("viewAllMessage")) {
			datas = jdbcTemplate.query(SELECTALL, args, new LetterRowMapper());
		}
		else if(lDTO.getSearchCondition().equals("viewAllMessageAdmin")) {
			datas = jdbcTemplate.query(SELECTALL_ADMIN_SUGGESTION, args, new LetterRowMapper());
		}
		else if(lDTO.getSearchCondition().equals("viewAllReportMessageAdmin")) {
			datas = jdbcTemplate.query(SELECTALL_ADMIN_REPORT, args, new LetterRowMapperReport());
		}
		return datas;
	}

	public LetterDTO selectOne(LetterDTO lDTO) {
		LetterDTO data = null;
		System.out.println("편지 PK id값 DAO: " + lDTO.getLetterId());
		Object[] args = { lDTO.getLetterId() };
		try {
			data = jdbcTemplate.queryForObject(SELECTONE, args, new LetterRowMapperViewOne());
		} catch (Exception e) {
			System.out.println("해당 편지 데이터가 없습니다");
		}
		return data;
	}

	public boolean insert(LetterDTO lDTO) {
		int result = jdbcTemplate.update(INSERT, lDTO.getSender(), lDTO.getLoginId(), lDTO.getTitle(),
				lDTO.getLetterContents());
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
			result = jdbcTemplate.update(UPDATE_ALL_READ, lDTO.getLoginId());
		}
		else if(lDTO.getSearchCondition().equals("updateAllUnRead")) {
			result = jdbcTemplate.update(UPDATE_ALL_UNREAD, lDTO.getLoginId());
		}
		else if(lDTO.getSearchCondition().equals("updateAllReadSuggestion")) {
			result = jdbcTemplate.update(UPDATE_ALL_READ_SUGGESTION_ADMIN, lDTO.getLoginId());
		}
		else if(lDTO.getSearchCondition().equals("updateAllUnReadSuggestion")) {
			result = jdbcTemplate.update(UPDATE_ALL_UNREAD_SUGGESTION_ADMIN, lDTO.getLoginId());
		}
		else if(lDTO.getSearchCondition().equals("updateAllReadReport")) {
			result = jdbcTemplate.update(UPDATE_ALL_READ_REPORT_ADMIN, lDTO.getLoginId());
		}
		else if(lDTO.getSearchCondition().equals("updateAllUnReadReport")) {
			result = jdbcTemplate.update(UPDATE_ALL_UNREAD_REPORT_ADMIN, lDTO.getLoginId());
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
		data.setSender(rs.getString("SENDER"));
		data.setTitle(rs.getString("TITLE"));
		data.setLetterContents(rs.getString("LETTER_CONTENTS"));
		data.setLetterDate(rs.getDate("LETTER_DATE"));
		data.setLetterStatus(rs.getString("LETTER_STATUS"));
		return data;
	}
}

class LetterRowMapperReport implements RowMapper<LetterDTO>{

	@Override
	public LetterDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		LetterDTO data = new LetterDTO();
		data.setLetterId(rs.getInt("LETTER_ID")); // 추가 필요
		data.setTitle(rs.getString("TITLE"));
		data.setLetterDate(rs.getDate("LETTER_DATE"));
		data.setLetterStatus(rs.getString("LETTER_STATUS"));
		return data;
	}
	
}
