package com.jarvis.BalanceGame.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jarvis.BalanceGame.model.dto.MemberItemDTO;

@Repository
public class MemberItemDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 해당 회원이 가지고 있는 모든 아이템
	private static final String SELECTALL ="SELECT I.ITEM_NAME, MI.MEMBER_ITEM_COUNT FROM MEMBER_ITEM MI INNER JOIN ITEM I ON MI.ITEM_ID = I.ITEM_ID WHERE MI.LOGIN_ID = ?";
	
	// 해당 회원이 해당 아이템의 소유 유무
	private static final String SELECTONE = "SELECT LOGIN_ID FROM MEMBER_ITEM WHERE LOGIN_ID = ? AND ITEM_ID = ?";
	
	// 해당 회원이 처음 아이템을 구매
	private static final String INSERT = "INSERT INTO MEMBER_ITEM (LOGIN_ID, ITEM_ID, MEMBER_ITEM_COUNT) VALUES (?, ?, ?)";
	
    // 해당 회원이 추가로 아이템을 구매 
	private static final String UPDATE_ADDITIONAL_PURCHASE ="UPDATE MEMBER_ITEM SET MEMBER_ITEM_COUNT = MEMBER_ITEM_COUNT + 1 WHERE LOGIN_ID = ? AND ITEM_ID = ?";
	
	// 해당 회원이 아이템을 사용 
	private static final String UPDATE_USE_ITEM = "UPDATE MEMBER_ITEM SET MEMBER_ITEM_COUNT = MEMBER_ITEM_COUNT - 1 WHERE LOGIN_ID = ? AND ITEM_ID = ?";
	
	
	public List<MemberItemDTO> selectAll(MemberItemDTO miDTO){
		List<MemberItemDTO> memberItemList = null;
		Object[] args = {miDTO.getLoginId()};
		memberItemList = jdbcTemplate.query(SELECTALL, args, new MemberItemRowMapper());
		return memberItemList;
	}
	
	public MemberItemDTO selectOne(MemberItemDTO miDTO) {
		MemberItemDTO memberItem = null;
		Object[] args = {miDTO.getLoginId(), miDTO.getItemId()};
		try {
			memberItem = jdbcTemplate.queryForObject(SELECTONE, args, new MemberItemRowMapperitemIsOwned());
		} catch (Exception e) {
			System.out.println("멤버 아이템 조회 불가");
		}
		return memberItem;
	}
	
	public boolean insert(MemberItemDTO miDTO) {
		int result = jdbcTemplate.update(INSERT, miDTO.getLoginId(), miDTO.getItemId(), miDTO.getMemberItemCount());
		if(result <= 0) {
			return false;
		}
		return true;
	}
	
	public boolean update(MemberItemDTO miDTO) {
		int result = 0;
		if(miDTO.getSearchCondition().equals("additionalPurchaseItem")) {
			result = jdbcTemplate.update(UPDATE_ADDITIONAL_PURCHASE, miDTO.getLoginId(), miDTO.getItemId());
		}
		else if(miDTO.getSearchCondition().equals("useItem")) {
			result = jdbcTemplate.update(UPDATE_USE_ITEM, miDTO.getLoginId(), miDTO.getItemId());
		}
		if(result <= 0) {
			return false;
		}
		return true;
	}
	
}

class MemberItemRowMapper implements RowMapper<MemberItemDTO>{

	@Override
	public MemberItemDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberItemDTO item = new MemberItemDTO();
		item.setItemName(rs.getString("ITEM_NAME"));
		item.setMemberItemCount(rs.getInt("MEMBER_ITEM_COUNT"));
		return item;
	}
}

class MemberItemRowMapperitemIsOwned implements RowMapper<MemberItemDTO>{

	@Override
	public MemberItemDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberItemDTO item = new MemberItemDTO();
		item.setLoginId(rs.getString("LOGIN_ID"));
		return item;
	}
	
}