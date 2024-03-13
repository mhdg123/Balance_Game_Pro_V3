package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinPageController {
	
	@RequestMapping("/joinPage")
	public String JoinPageController() {

		return "redirect:join";
	}
}
