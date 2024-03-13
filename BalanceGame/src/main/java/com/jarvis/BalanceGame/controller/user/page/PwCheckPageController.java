package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PwCheckPageController {
	@RequestMapping("/pwCheckPage")
	public String pwCheckPageController() {
		
		return "redirect:passwardCheck";
	}
}
