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

	
	class PaymentRowMapper implements RowMapper<PaymentDTO> {

		@Override
		public PaymentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			PaymentDTO data = new PaymentDTO();
			data.setLoginId(rs.getString("LOGIN_ID"));
			data.setAmount(rs.getInt("AMOUNT"));
			data.setPaymentDate(rs.getDate("PAYMENT_DATE"));
			return data;
		}
	}


	

}
