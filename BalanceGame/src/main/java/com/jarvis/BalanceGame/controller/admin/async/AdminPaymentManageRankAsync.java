package com.jarvis.BalanceGame.controller.admin.async;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jarvis.BalanceGame.model.dto.PaymentDTO;
import com.jarvis.BalanceGame.service.PaymentService;

public class AdminPaymentManageRankAsync {

//	@Autowired
//	private PaymentService paymentService;
//	
//	@RequestMapping("/adminPaymentManageRankAsync")
//	public @ResponseBody String adminPaymentManageRankAsync(PaymentDTO pDTO, Gson gson) {
//		
//		pDTO.setSearchCondition("후원순");
//		List<PaymentDTO> sRankDatas = paymentService.selectAll(pDTO);
//
//		if(sRankDatas == null) {
//			return "실패";
//		}
//		System.out.println(gson.toJson(sRankDatas));
//		return gson.toJson(sRankDatas);
//	}
}
