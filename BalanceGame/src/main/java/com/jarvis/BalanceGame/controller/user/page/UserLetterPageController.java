package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserLetterPageController {

	@GetMapping("/letterPage")
	public String userSuggestionPageController(Model model, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		model.addAttribute("loginId", loginId);
		
		
		return "user/userSuggestion";
	}
}
