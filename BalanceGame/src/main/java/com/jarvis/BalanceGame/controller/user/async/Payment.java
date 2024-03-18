package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.PaymentDTO;
import com.jarvis.BalanceGame.service.PaymentService;

import jakarta.servlet.http.HttpSession;

public class Payment {

//	@Autowired
//	private PaymentService paymentService;
//	
//	@RequestMapping("/payment")
//	public @ResponseBody String payment(PaymentDTO pDTO, HttpSession session) {
//		pDTO.setLoginId((String)session.getAttribute("login"));
//		pDTO.setSearchCondition("후원");
//		
//		System.out.println("데이터 : " + pDTO.getLoginId()); // 데이터옴?
//		System.out.println("파라미터 후원 금액" + pDTO.getAmount());
//		
//		boolean payment = paymentService.insert(pDTO);
//		
//		if (payment) {
//			// 후원성공
//			return "성공";
//		}
//			// 후원실패
//			return "실패";
//		
//	}
}
