package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class PwCheckPageController {
	@GetMapping("/pwCheckPage")
	public String pwCheckPageController() {
		
		return "/user/passwardCheck";
	}
}
