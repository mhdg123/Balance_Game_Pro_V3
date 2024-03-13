package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;

@Controller
public class LoginPageController {

	public String LoginPageController() {
		
		return "redirect:login";
	}
}
