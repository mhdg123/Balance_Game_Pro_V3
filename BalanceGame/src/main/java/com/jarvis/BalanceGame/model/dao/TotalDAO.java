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
			+ "    months.Month,\r\n"
			+ "    IFNULL(SUM(TOTAL_AMOUNT), 0) AS Total_Amount\r\n"
			+ "FROM \r\n"
			+ "    (\r\n"
			+ "        SELECT 1 AS Month\r\n"
			+ "        UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6\r\n"
			+ "        UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION SELECT 11 UNION SELECT 12\r\n"
			+ "    ) AS months\r\n"
			+ "LEFT JOIN \r\n"
			+ "    (\r\n"
			+ "        SELECT \r\n"
			+ "            MONTH(TOTAL_DATE) AS Month,\r\n"
			+ "            TOTAL_AMOUNT\r\n"
			+ "        FROM \r\n"
			+ "            TOTAL\r\n"
			+ "    ) AS subquery ON months.Month = subquery.Month \r\n"
			+ "GROUP BY \r\n"
			+ "    months.Month\r\n"
			+ "ORDER BY \r\n"
			+ "    months.Month";
	
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
		data.setTotalAmount(rs.getInt("Total_Amount"));
		return data;
	}
}