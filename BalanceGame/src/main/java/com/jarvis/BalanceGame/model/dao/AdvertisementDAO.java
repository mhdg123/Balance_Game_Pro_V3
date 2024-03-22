package com.jarvis.BalanceGame.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jarvis.BalanceGame.model.dto.AdvertisementDTO;

@Repository
public class AdvertisementDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECTALL = "SELECT ADVERTISEMENT_ID, ADVERTISEMENT_URL, ADVERTISEMENT_IMAGE, ADVERTISEMENT_STATUS FROM ADVERTISEMENT";
	private static final String SELECTONE = "";
	private static final String INSERT = "";
	private static final String UPDATE = "";
	private static final String DELETE = "";
	
	public List<AdvertisementDTO> selectAll(AdvertisementDTO adDTO){
		List<AdvertisementDTO> ad = null;
		ad = jdbcTemplate.query(SELECTALL, new AdvertisementRowMapper());
		return ad;
	}

	public AdvertisementDTO selectOne(AdvertisementDTO adDTO) {
		
	}
	
	public boolean insert(AdvertisementDTO adDTO) {
		return false;
	}
	
	public boolean update(AdvertisementDTO adDTO) {
		return false;
	}
	public boolean delete(AdvertisementDTO adDTO) {
		return false;
	}
	
}

class AdvertisementRowMapper implements RowMapper<AdvertisementDTO>{

	@Override
	public AdvertisementDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdvertisementDTO ad = new AdvertisementDTO();
		ad.setAdvertisementId(rs.getInt("ADVERTISEMENT_ID"));
		ad.setAdvertisementUrl(rs.getString("ADVERTISEMENT_URL"));
		ad.setAdvertisementImg(rs.getString("ADVERTISEMENT_IMAGE"));
		ad.setAdvertisementStatus(rs.getString("ADVERTISEMENT_STATUS"));
		return ad;
	}
}