package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AgreementPageController {

	@RequestMapping("/약관동의!!")
	public String agreementPageController(Model model, HttpSession session) {
		
		String loginId = (String)session.getAttribute("loginId");
		
		model.addAttribute("loginId", loginId);
		
		return "user/아직모름";
	}
	
}
