package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainPageController {

	@Autowired MemberService memberService;
	@GetMapping("/")
	public @ResponseBody String mainPageController() {
	System.out.println("메인페이지 이동");
	
	MemberDTO dto = new MemberDTO();
	dto.setSearchCondition("viewAll");
	memberService.selectAll(dto);
	
		return "ok";
	}
}
