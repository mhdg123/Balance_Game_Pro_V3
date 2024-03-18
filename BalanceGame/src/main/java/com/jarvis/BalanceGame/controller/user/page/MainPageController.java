package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainPageController {

	@GetMapping({"/","/main"})
	public  String mainPageController() {
	System.out.println("메인페이지 이동");
	
	
		return "user/index";
	}
	
	@GetMapping("/alert/{msg}/{status}/{redirect}") 
	public String alert(@PathVariable("msg") String msg, @PathVariable("status") String status, @PathVariable("redirect") String redirect, Model model) {
		System.out.println("상태 " + status);
		System.out.println("메세지 " + msg);
		System.out.println("이동할 경로 " + redirect);
		model.addAttribute("status", status);
		if(redirect != null) {
			redirect = "/" + redirect;
			model.addAttribute("redirect", redirect);
		}
		model.addAttribute("msg", msg);
		return "alert";
	}
}
