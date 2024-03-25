package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class AgreementPageController {

	@RequestMapping("/joinAgree")
	public String agreementPageController(Model model, HttpSession session) {
		System.out.println("약관동의 페이지 이동");
		
		return "user/joinAgree";
	}
	
}
