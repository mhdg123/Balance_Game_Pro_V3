package com.jarvis.BalanceGame.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.jarvis.BalanceGame.model.dto.ItemDTO;

@Repository
public class ItemDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SELECTALL_ITEM_TYPE = "SELECT ITEM_ID, ITEM_NAME, ITEM_PRICE, ITEM_IMAGE FROM ITEM WHERE ITEM_TYPE = 'item' ";
	private static final String SELECTALL_POINT_TYPE = "SELECT ITEM_ID, ITEM_NAME, ITEM_PRICE, ITEM_IMAGE FROM ITEM WHERE ITEM_TYPE = 'point' ";
	private static final String SELECTONE = "SELECT ITEM_ID, ITEM_NAME, ITEM_PRICE, ITEM_IMAGE, ITEM_TYPE FROM ITEM WHERE ITEM_ID =?";
	private static final String SELECTONE_NEXT_ID = "SELECT MAX(ITEM_ID)+1 AS NEXT_ITEM_ID FROM ITEM";
	private static final String INSERT = "INSERT INTO ITEM (ITEM_NAME, ITEM_PRICE, ITEM_IMAGE, ITEM_TYPE) VALUES (?,?,?,?)";
	private static final String UPDATE = "UPDATE ITEM SET ITEM_NAME = ?, ITEM_PRICE = ?, ITEM_IMAGE = ? WHERE ITEM_ID = ?";
	private static final String DELETE = "DELETE FROM ITEM WHERE ITEM_ID = ?";

	public List<ItemDTO> selectAll(ItemDTO iDTO) {
		List<ItemDTO> datas = null;
		if (iDTO.getSearchCondition().equals("itemType")) {
			datas = jdbcTemplate.query(SELECTALL_ITEM_TYPE, new ItemRowMapper());
		} else if (iDTO.getSearchCondition().equals("pointType")) {
			datas = jdbcTemplate.query(SELECTALL_POINT_TYPE, new ItemRowMapper());
		}
		return datas;
	}

	public ItemDTO selectOne(ItemDTO iDTO) {
		ItemDTO data = null;
		try {
			if (iDTO.getSearchCondition().equals("itemViewOne")) {
				Object[] args = { iDTO.getItemId() };
				data = jdbcTemplate.queryForObject(SELECTONE, args, new ItemRowMapperDetail());
			} else if (iDTO.getSearchCondition().equals("itemNextId")) {
				data = jdbcTemplate.queryForObject(SELECTONE_NEXT_ID, new ItemRowMapperNextId());
			}
		} catch (Exception e) {
			System.out.println("해당 아이템 데이터가 없습니다");
		}
		return data;
	}

	public boolean insert(ItemDTO iDTO) {
		int result = jdbcTemplate.update(INSERT, iDTO.getItemName(), iDTO.getItemPrice(), iDTO.getItemImg(),
				iDTO.getItemType());
		if (result <= 0) {
			return false;
		}
		return true;
	}

	public boolean update(ItemDTO iDTO) {
		int result = jdbcTemplate.update(UPDATE, iDTO.getItemName(), iDTO.getItemPrice(),iDTO.getItemImg(), iDTO.getItemId());
		if (result <= 0) {
			return false;
		}
		return true;
	}

	public boolean delete(ItemDTO iDTO) {
		int result = jdbcTemplate.update(DELETE, iDTO.getItemId());
		if (result <= 0) {
			return false;
		}
		return true;
	}
}

class ItemRowMapper implements RowMapper<ItemDTO> {

	@Override
	public ItemDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ItemDTO datas = new ItemDTO();
		datas.setItemId(rs.getInt("ITEM_ID"));
		datas.setItemName(rs.getString("ITEM_NAME"));
		datas.setItemPrice(rs.getInt("ITEM_PRICE"));
		datas.setItemImg(rs.getString("ITEM_IMAGE"));
		return datas;
	}
}

class ItemRowMapperDetail implements RowMapper<ItemDTO> {

	@Override
	public ItemDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ItemDTO data = new ItemDTO();
		data.setItemId(rs.getInt("ITEM_ID"));
		data.setItemName(rs.getString("ITEM_NAME"));
		data.setItemPrice(rs.getInt("ITEM_PRICE"));
		data.setItemImg(rs.getString("ITEM_IMAGE"));
		data.setItemType(rs.getString("ITEM_TYPE"));
		return data;
	}
}

class ItemRowMapperNextId implements RowMapper<ItemDTO> {

	@Override
	public ItemDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ItemDTO data = new ItemDTO();
		data.setItemNextId(rs.getInt("NEXT_ITEM_ID"));
		return data;
	}
}