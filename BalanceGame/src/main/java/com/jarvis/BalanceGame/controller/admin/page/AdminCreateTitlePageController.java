package com.jarvis.BalanceGame.controller.admin.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminCreateTitlePageController {

	@RequestMapping("/adminCreateTitlePage")
	public String AdminCreateTitlePageController() {
		
		return "redirect:adminMakeTitle";
	}
	
}
