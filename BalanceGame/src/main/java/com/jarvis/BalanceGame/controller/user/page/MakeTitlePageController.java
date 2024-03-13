package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MakeTitlePageController {

	@RequestMapping("/makeTitlePage")
	public String MakeTitlePageController() {
		
		return "redirect:makeTitle";
	}
}
