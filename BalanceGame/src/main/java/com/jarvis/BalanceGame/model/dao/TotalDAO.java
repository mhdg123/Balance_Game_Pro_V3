package com.jarvis.BalanceGame.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jarvis.BalanceGame.model.dto.TotalDTO;

@Repository
public class TotalDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECT_ALL_TOTAL_MONTH = "SELECT \r\n"
			+ "    YEAR(CURRENT_TIMESTAMP) AS Year,\r\n"
			+ "    months.month AS Month,\r\n"
			+ "    COALESCE(SUM(total.TOTAL_AMOUNT), 0) AS TotalAmount\r\n"
			+ "FROM (\r\n"
			+ "    SELECT 1 AS month\r\n"
			+ "    UNION SELECT 2\r\n"
			+ "    UNION SELECT 3\r\n"
			+ "    UNION SELECT 4\r\n"
			+ "    UNION SELECT 5\r\n"
			+ "    UNION SELECT 6\r\n"
			+ "    UNION SELECT 7\r\n"
			+ "    UNION SELECT 8\r\n"
			+ "    UNION SELECT 9\r\n"
			+ "    UNION SELECT 10\r\n"
			+ "    UNION SELECT 11\r\n"
			+ "    UNION SELECT 12\r\n"
			+ ") AS months\r\n"
			+ "LEFT JOIN TOTAL total ON MONTH(total.TOTAL_DATE) = months.month AND YEAR(total.TOTAL_DATE) = YEAR(CURRENT_TIMESTAMP)\r\n"
			+ "GROUP BY Year, months.month";
	
	public List<TotalDTO> selectAll(TotalDTO tDTO){
		List<TotalDTO> datas = null;
		datas = jdbcTemplate.query(SELECT_ALL_TOTAL_MONTH, new TotalRowMapper());
		return datas;
	}
}


class TotalRowMapper implements RowMapper<TotalDTO>{

	@Override
	public TotalDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TotalDTO data = new TotalDTO();
		data.setMonth(rs.getString("Month"));
		data.setTotalAmount(rs.getInt("TotalAmount"));
		return data;
	}
}