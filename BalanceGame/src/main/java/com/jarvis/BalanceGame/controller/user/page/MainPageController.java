package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class MainPageController {

	@GetMapping("/main")
	public String mainPageController() {
	System.out.println("메인페이지 이동");
		return "/user/index";
	}
}
