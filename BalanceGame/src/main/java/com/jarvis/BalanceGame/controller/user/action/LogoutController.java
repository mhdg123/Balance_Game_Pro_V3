package com.jarvis.BalanceGame.controller.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/logout")
	public String LogoutController(MemberDTO mDTO, Model model,HttpSession session) {
		
		model.addAttribute("UTF-8");
		model.addAttribute("msg", "로그아웃 완료");
		model.addAttribute("status", "success");
		session.removeAttribute("loginId");
		
		return "alert";
	}
}
