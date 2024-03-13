package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserSuggestionPageController {

	@RequestMapping("/")
	public String UserSuggestionPageController(Model model, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		model.addAttribute("loginId", loginId);
		
		
		return "userSuggestion";
	}
}
