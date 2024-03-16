package com.jarvis.BalanceGame.controller.user.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LogoutController {
	
	
	@GetMapping("/logout")
	public String logoutController(MemberDTO mDTO, Model model,HttpSession session) {
		System.out.println("로그아웃 기능 실행");
		session.removeAttribute("loginId");
		model.addAttribute("msg", "로그아웃 완료");
		model.addAttribute("status", "success");
		model.addAttribute("redirect","/");
		
		return "alert";
	}
}
