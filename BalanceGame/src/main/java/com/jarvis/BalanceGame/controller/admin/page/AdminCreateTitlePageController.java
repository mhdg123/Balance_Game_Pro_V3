package com.jarvis.BalanceGame.controller.admin.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminCreateTitlePageController {

	@GetMapping("/adminCreateTitlePage")
	public String adminCreateTitlePageController() {
		
		return "/admin/adminMakeTitle";
	}
	
}
