package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jarvis.BalanceGame.model.dto.MemberItemDTO;
import com.jarvis.BalanceGame.service.MemberItemService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class NameChangeCouponAsync {

	@Autowired
	private MemberItemService memberItemService;
	
	@PostMapping("/nameChangeCouponAsync")
	public @ResponseBody String nameChangeCouponAsync(MemberItemDTO miDTO, Gson gson, Model model, HttpSession session) {
		
		  // 유저가 닉네임변경권 아이템을 가지고 있는지 확인을 함
		// 아이템이 있을경우 아이템 하나를 사용해서 닉네임 변경할수 있게 만듬
		// 비동기로 이루어져야함
		// 반환값을 뭐로 줘야 할까?
		String loginId = (String)session.getAttribute("loginId");
		miDTO.setLoginId(loginId);
		
		// 유저가 아이템 있는지 유무 확인
		miDTO = memberItemService.selectOne(miDTO);
		
		if(miDTO == null) {
			
			
			return "fail";
		}
		
		// 아이템이 있으면
		// 아이템 하나 사용
		// 아이템 업데이트 해서 하나 사용하기
		// 하나 소모한대신 뷰에서 정보변경 가능하게 하기

		return "success";
	}
	
//	@PostMapping("/nameChangeCoupon")
//	public @ResponseBody String nameChangeUpdate(MemberItemDTO miDTO, Gson gson, Model model, HttpSession session) {
//		
//		// 변경을 누르면 여기로 와서 변경권 1 차감시킴
//		String loginId = (String)session.getAttribute("loginId");
//		miDTO.setLoginId(loginId);
//		miDTO.setSearchCondition("useItem");
//		memberItemService.update(miDTO);
//		
//		
//		
//		return "success";
//	}
	
	
	
	
}
