//package com.jarvis.BalanceGame.controller.admin.async;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.google.gson.Gson;
//import com.jarvis.BalanceGame.model.dto.PaymentDTO;
//import com.jarvis.BalanceGame.service.PaymentService;
//
//public class AdminPaymentManageDateAsync {
//
//	@Autowired
//	private PaymentService paymentService;
//	
//	@RequestMapping("/adminPaymentManageDateAsync")
//	public @ResponseBody String adminPaymentManageDateAsync(PaymentDTO pDTO, Gson gson) {
//		
//		pDTO.setSearchCondition("최신순");
//		List<PaymentDTO> pData = paymentService.selectAll(pDTO);
//		System.out.println("[로그: 최신순 ]"+pData);
//
//		if(pData == null) {// 데이터가 없다면
//			return "실패";
//		}
//		System.out.println("[로그: 최신순]"+gson.toJson(pData));
//		return gson.toJson(pData);
//		
//	}
//}