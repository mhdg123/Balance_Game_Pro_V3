package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class ResultPageController {

	@GetMapping("/gameResultPage")
	public String resultPageController() {
		
		return "user/gameReuslt";
	}
}
