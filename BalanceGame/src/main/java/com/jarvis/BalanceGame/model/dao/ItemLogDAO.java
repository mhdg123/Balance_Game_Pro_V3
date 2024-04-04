//package com.jarvis.BalanceGame.model.dao;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import com.jarvis.BalanceGame.model.dto.ItemLogDTO;
//
//@Repository
//public class ItemLogDAO {
//
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
//	private static final String INSERT = "INSERT INTO ITEM_LOG (ITEM_ID, ITEM_LOG_COUNT) VALUES (?, ?)";
//	private static final String SELECTALL = "SELECT ITEM.ITEM_NAME, ITEM_LOG.ITEM_ID, SUM(ITEM_LOG.ITEM_LOG_COUNT) AS TOTAL_COUNT FROM ITEM JOIN "
//			+ " ITEM_LOG ON ITEM.ITEM_ID = ITEM_LOG.ITEM_ID GROUP BY ITEM.ITEM_NAME, ITEM_LOG.ITEM_ID";
//	
//	public List<ItemLogDTO> selectAll(ItemLogDTO iDTO){
//		List<ItemLogDTO> datas = null;
//		datas = jdbcTemplate.query(SELECTALL, new ItemLogMapperRow());
//		return datas;
//	}
//	
//	public boolean insert(ItemLogDTO iDTO) {
//		int result = jdbcTemplate.update(INSERT, iDTO.getItemId(), iDTO.getItemLogCount());
//		if(result <= 0) {
//			return false;
//		}
//		return true;
//	}
//}
//
//class ItemLogMapperRow implements RowMapper<ItemLogDTO>{
//
//	@Override
//	public ItemLogDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//		ItemLogDTO data = new ItemLogDTO();
//		data.setItemId(rs.getInt("ITEM_ID"));
//		data.setItemName(rs.getString("ITEM_NAME"));
//		data.setTotalCount(rs.getInt("TOTAL_COUNT"));
//		return data;
//	}
//}