package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class SearchMyInfoPageController {
	
	@GetMapping("/searchMyInfoPage")
	public String searchMyInfoPageController(){
		
		return "user/searchMyInfo";
	}
}
