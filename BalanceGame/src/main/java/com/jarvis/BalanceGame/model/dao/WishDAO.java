package com.jarvis.BalanceGame.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jarvis.BalanceGame.model.dto.WishDTO;

@Repository
public class WishDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SELECTALL = "SELECT Q.TITLE FROM SAVE S JOIN QUESTIONS Q ON S.QID = Q.QID WHERE S.LOGIN_ID = ?";

	private static final String SELECTONE = "SELECT QUESIONT_ID, LOGIN_ID FROM SAVE WHERE LOGIN_ID=? AND QUESIONT_ID=?";

	private static final String INSERT = "INSERT INTO SAVE (SID, QID,LOGIN_ID) \r\n"
			+ "VALUES((SELECT NVL(MAX(SID),0) + 1 FROM SAVE),?,?)";

	private static final String DELETE = "DELETE FROM SAVE WHERE SID=?";

	// 사용자가 찜한 문제 전체 조회
	public List<WishDTO> selectAll(WishDTO wDTO) {
		Object[] args = { wDTO.getLoginId() };
		return jdbcTemplate.query(SELECTALL, args, new WishRowMapper());
	}

	public WishDTO selectOne(WishDTO wDTO) {
		Object[] args = { wDTO.getLoginId(), wDTO.getQuestionId() };
		return jdbcTemplate.queryForObject(SELECTONE, args, new WishRowMapperStatus());
	}

	public boolean insert(WishDTO wDTO) {
		// 찜하기
		int result = jdbcTemplate.update(INSERT, wDTO.getQuestionId(), wDTO.getLoginId());
		if (result <= 0) {
			return false;
		}
		return true;
	}

	private boolean update(WishDTO wDTO) {
		return false;
	}

	public boolean delete(WishDTO wDTO) {
		int result = jdbcTemplate.update(DELETE, wDTO.getWishId());
		if (result <= 0) {
			return false;
		}
		return true;
	}

}

class WishRowMapper implements RowMapper<WishDTO> {

	@Override
	public WishDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		WishDTO data = new WishDTO();
		data.setQuestionTitle(rs.getString("TITLE"));
		return data;
	}
}

class WishRowMapperStatus implements RowMapper<WishDTO> {

	@Override
	public WishDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		WishDTO data = new WishDTO();
		data.setQuestionId(rs.getInt("QUESIONT_ID"));
		data.setLoginId(rs.getString("LOGIN_ID"));
		return data;
	}
}
