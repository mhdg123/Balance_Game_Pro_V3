package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NaverLoginPageController {

	@GetMapping("/naverLogin")
	public String naverLoginPageController() {
		return "user/naverLogin";
	}
}
