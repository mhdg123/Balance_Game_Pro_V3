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
	
	private static final String SELECTALL = "SELECT ADVERTISEMENT_ID, ADVERTISEMENT_URL, ADVERTISEMENT_IMAGE, ADVERTISEMENT_STATUS FROM ADVERTISEMENT "
			+ "ORDER BY ADVERTISEMENT_ID DESC";
	private static final String SELECTONE_RANDOM = "SELECT ADVERTISEMENT_ID, ADVERTISEMENT_URL, ADVERTISEMENT_IMAGE, ADVERTISEMENT_STATUS FROM ADVERTISEMENT ORDER BY RAND() LIMIT 1";
	private static final String SELECTONE_DETAIL = "SELECT ADVERTISEMENT_ID, ADVERTISEMENT_URL, ADVERTISEMENT_IMAGE, ADVERTISEMENT_STATUS FROM ADVERTISEMENT WHERE ADVERTISEMENT_ID = ?";
	private static final String SELECTONE_NEXT_ID = "SELECT MAX(ADVERTISEMENT_ID)+1 AS NEXT_AD_ID FROM ADVERTISEMENT";
	private static final String INSERT = "INSERT INTO ADVERTISEMENT (ADVERTISEMENT_URL, ADVERTISEMENT_IMAGE) VALUES (?, ?)";
	private static final String UPDATE_SHOW_HIDE = "UPDATE ADVERTISEMENT SET ADVERTISEMENT_STATUS = CASE WHEN ADVERTISEMENT_STATUS = 'F' THEN 'T' ELSE 'F' END WHERE ADVERTISEMENT_ID = ?";
	private static final String UPDATE = "UPDATE ADVERTISEMENT SET ADVERTISEMENT_URL = ?, ADVERTISEMENT_IMAGE = ? WHERE ADVERTISEMENT_ID = ?";
	private static final String DELETE = "DELETE FROM ADVERTISEMENT WHERE ADVERTISEMENT_ID = ?";
	
	public List<AdvertisementDTO> selectAll(AdvertisementDTO adDTO){
		List<AdvertisementDTO> adList = null;
		adList = jdbcTemplate.query(SELECTALL, new AdvertisementRowMapper());
		return adList;
	}

	public AdvertisementDTO selectOne(AdvertisementDTO adDTO) {
		AdvertisementDTO ad = null;
		try {
			if(adDTO.getSearchCondition().equals("adRandomChoice")) {
				Object[] args = {};
				ad = jdbcTemplate.queryForObject(SELECTONE_RANDOM, args, new AdvertisementRowMapper());
			}
			else if(adDTO.getSearchCondition().equals("adViewOne")) {
				Object[] args = {adDTO.getAdvertisementId()};
				ad = jdbcTemplate.queryForObject(SELECTONE_DETAIL, args, new AdvertisementRowMapper());
			}
			else if(adDTO.getSearchCondition().equals("adNextId")) {
				ad = jdbcTemplate.queryForObject(SELECTONE_NEXT_ID, new AdvertisementNextId());
			}
		} catch (Exception e) {
			System.out.println("광고 상세보기 조회 실패");
		}
		return ad;
	}
	
	public boolean insert(AdvertisementDTO adDTO) {
		int result = jdbcTemplate.update(INSERT, adDTO.getAdvertisementUrl(), adDTO.getAdvertisementImg());
		if(result <= 0) {
			return false;
		}
		return true;
	}
	
	public boolean update(AdvertisementDTO adDTO) {
		int result = 0;
		if(adDTO.getSearchCondition().equals("adShowAndHide")) {
			result = jdbcTemplate.update(UPDATE_SHOW_HIDE, adDTO.getAdvertisementId());
		}
		else if(adDTO.getSearchCondition().equals("adModification")) {
			result = jdbcTemplate.update(UPDATE, adDTO.getAdvertisementUrl(), adDTO.getAdvertisementImg(), adDTO.getAdvertisementId());
		}
		if(result <= 0) {
			return false;
		}
		return true;
	}
	public boolean delete(AdvertisementDTO adDTO) {
		int result = jdbcTemplate.update(DELETE, adDTO.getAdvertisementId());
		if(result <= 0) {
			return false;
		}
		return true;
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

class AdvertisementNextId implements RowMapper<AdvertisementDTO>{

	@Override
	public AdvertisementDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdvertisementDTO ad = new AdvertisementDTO();
		ad.setAdvertisementNextId(rs.getInt("NEXT_AD_ID"));
		return ad;
	}
}