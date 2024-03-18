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
	
	private static final String CHARGE_POINT = "INSERT INTO PAYMENT (LOGIN_ID, AMOUNT) VALUES (?, ?)"; // INPUT : 로그인 아이디, 결제 금액 

//	public List<PaymentDTO> selectAll(QuestionDTO qDTO) {

//		// 문제 모두 조회
//		if (qDTO.getSearchCondition().equals("viewAllOfQuestionList")) {
//			Object[] args = { qDTO.getWriter() };
//			return jdbcTemplate.query("", args, new QuestionRowMapperList());
//		}
//		// 크롤링 문제조회
//		else if (qDTO.getSearchCondition().equals("crawling")) {
//			System.out.println("로그 qDAO: 크롤링");
//			return jdbcTemplate.query("", new QuestionRowMapper());
//		}
//		// 관리자가 승인한 문제조회
//		else if (qDTO.getSearchCondition().equals("adminViewAllOfApprovedQuestions")) {
//			return jdbcTemplate.query("", new QuestionRowMapper());
//		}
//		// 관리자가 승인하지 않은 문제조회
//		else if (qDTO.getSearchCondition().equals("adminViewAllOfUnapprovedQuestions")) {
//			return jdbcTemplate.query("", new QuestionRowMapper());
//		}
//		return null;
//	}

//	public PaymentDTO selectOne(PaymentDTO pDTO) {
//
//		// 문제 상세보기
//		if (pDTO.getSearchCondition().equals("chargePoint")) {
//			Object[] args = { pDTO.getLoginId(), pDTO.getAmount() };
//			return jdbcTemplate.queryForObject("", args, new PaymentRowMapper());
//		}
//
//		return null;
//	}
	
	public boolean insert(PaymentDTO pDTO) {
		int result = 0;
		// 문제 상세보기
		if (pDTO.getSearchCondition().equals("chargePoint")) {
			result = jdbcTemplate.update(CHARGE_POINT, pDTO.getLoginId(), pDTO.getAmount());
			if(result >= 0) {
				return true;
			}
			
		}
		return false;
	}

	
	class PaymentRowMapper implements RowMapper<PaymentDTO> {

		@Override
		public PaymentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			PaymentDTO data = new PaymentDTO();
			data.setLoginId(rs.getString("LOGIN_ID"));
			data.setAmount(rs.getInt("AMOUNT"));
			return data;
		}
	}


	

}
