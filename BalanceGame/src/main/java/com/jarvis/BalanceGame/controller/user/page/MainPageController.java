package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainPageController {

	@RequestMapping("/myPage")
	public String MainPageController(HttpSession session) {
		session.removeAttribute("qList");
		return "redirect:main";
	}
}
