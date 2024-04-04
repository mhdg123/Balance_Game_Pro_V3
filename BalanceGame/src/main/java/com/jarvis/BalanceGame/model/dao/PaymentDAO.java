package com.jarvis.BalanceGame.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jarvis.BalanceGame.model.dto.PaymentDTO;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;

@Repository
public class PaymentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 포인트 구매 
	private static final String PURCHASE_POINT = "INSERT INTO PAYMENT (LOGIN_ID, AMOUNT) VALUES (?, ?)"; // INPUT : 로그인 아이디, 결제 금액 
	private static final String SELECT_TOTAL = "SELECT SUM(AMOUNT) AS TOTAL_AMOUNT FROM PAYMENT";
	private static final String SELECT_ONE_CNT = "SELECT COUNT(DISTINCT LOGIN_ID) AS CNT "
			+ "FROM PAYMENT";
	
	public boolean insert(PaymentDTO pDTO) {
		int result = 0;
		
		if (pDTO.getSearchCondition().equals("purchasePoint")) {
			result = jdbcTemplate.update(PURCHASE_POINT, pDTO.getLoginId(), pDTO.getAmount());
			if(result <=0 ) {
				return false;
			}
		}
		return true;
	}

	public PaymentDTO selectOne(PaymentDTO pDTO) {
		PaymentDTO data = null;
		if(pDTO.getSearchCondition().equals("viewOnepaymentTotal")) {
			try {
				data = jdbcTemplate.queryForObject(SELECT_TOTAL, new PaymentRowMapperTotal());
			} catch (Exception e) {
				System.out.println("총 결제금액 조회 불가");
			}
		}
		if(pDTO.getSearchCondition().equals("viewCnt")) {
			try {
				data = jdbcTemplate.queryForObject(SELECT_ONE_CNT, new PaymentRowMapperCnt());
			} catch (Exception e) {
				System.out.println("총 개수 조회 불가");
				e.printStackTrace();
			}
		}
		return data;
	}
	
}

class PaymentRowMapperTotal implements RowMapper<PaymentDTO> {
	
	@Override
	public PaymentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PaymentDTO data = new PaymentDTO();
		data.setTotalAmount((rs.getInt("TOTAL_AMOUNT")));
		return data;
	}
}

class PaymentRowMapperCnt implements RowMapper<PaymentDTO>{

	@Override
	public PaymentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PaymentDTO data = new PaymentDTO();
		data.setCnt(rs.getInt("CNT"));
		return data;
	}
	
}