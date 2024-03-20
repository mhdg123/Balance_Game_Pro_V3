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

	// 사용자가 찜한 문제 전체 조회
	private static final String SELECTALL = "SELECT Q.TITLE FROM WISH W JOIN QUESTIONS Q ON S.QUESTION_ID = Q.QUESTION_ID WHERE W.LOGIN_ID = ?";

	// 문제에 대한 사용자의 찜의 유무 조회 
	private static final String SELECTONE = "SELECT QUESTION_ID, LOGIN_ID FROM WISH WHERE LOGIN_ID=? AND QUESTION_ID=?";

	// 사용자가 해당 문제를 찜
	private static final String INSERT = "INSERT INTO WISH (QUESTION_ID, LOGIN_ID) VALUES(?,?)";

	// 사용자가 해당 문제를 찜 해제 
	private static final String DELETE = "DELETE FROM WISH WHERE LOGIN_ID=? AND QUESTION_ID = ?";

	// 사용자가 찜한 문제 전체 조회
	public List<WishDTO> selectAll(WishDTO wDTO) {
		Object[] args = { wDTO.getLoginId() };
		List<WishDTO> datas = null;
		try {
			datas = jdbcTemplate.query(SELECTALL, args, new WishRowMapper());
		} catch (Exception e) {
			System.out.println("찜에 대한 결과를 조회할 수 없습니다");
		}
		return datas;
	}

	public WishDTO selectOne(WishDTO wDTO) {
		Object[] args = { wDTO.getLoginId(), wDTO.getQuestionId() };
		WishDTO data = null;
		try {
			data = jdbcTemplate.queryForObject(SELECTONE, args, new WishRowMapperStatus());
		} catch (Exception e) {
			System.out.println("찜에 대한 결과를 조회할 수 없습니다");
		}
		return data;
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
		int result = jdbcTemplate.update(DELETE, wDTO.getLoginId(), wDTO.getQuestionId());
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
		data.setQuestionId(rs.getInt("QUESTION_ID"));
		data.setLoginId(rs.getString("LOGIN_ID"));
		return data;
	}
}
