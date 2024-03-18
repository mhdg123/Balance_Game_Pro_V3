package com.jarvis.BalanceGame.controller.user.async;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jarvis.BalanceGame.model.dto.ItemDTO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.PaymentDTO;
import com.jarvis.BalanceGame.service.PaymentService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/async")
public class PaymentAsync {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/payment")
	public @ResponseBody String payment(PaymentDTO pDTO, MemberDTO mDTO, ItemDTO iDTO, HttpSession session,
			Map<String, String> datas) {
		Gson gson = new Gson();
		System.out.println("카카오페이 기능 실행");
		pDTO.setSearchCondition("chargePoint");
		String loginId = (String) session.getAttribute("loginId");
		loginId = "테스트유저";
		int amount = pDTO.getAmount();
		int point = mDTO.getCoin();
		System.out.println("결제하는 회원 아이디" + loginId); // 데이터옴?
		System.out.println("결제한 아이템 이름" + iDTO.getItemName());
		System.out.println("아이템 가격" + amount);
		point = (int) ((double) amount * 0.1);
		System.out.println("충전된 포인트 " + point);
		
		boolean paymentResult = paymentService.insert(pDTO);
		if (paymentResult) {
			// 포인트 충전 성공
			System.out.println("포인트 충전 성공");
			datas.put("status", "success");
		} else {
			System.out.println("포인트 충전 실패");
			datas.put("status", "fail");
		}
		

		return gson.toJson(datas);

	}
}
