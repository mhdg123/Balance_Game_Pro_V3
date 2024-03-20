package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jarvis.BalanceGame.controller.CrawlingListener;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;

@Controller
public class MainPageController {

	@Autowired
	private CrawlingListener crawlingListener;
	
	@GetMapping({"/","/main"})
	public  String mainPageController(QuestionDTO qDTO, Model model) {
	System.out.println("메인페이지 이동");
	
	
	if(crawlingListener.getCount()<=0) {
	crawlingListener.crawlingListener(qDTO, model);
	}
	
	
	//1. 여기서 메서드 불러야됨
	//2. 그러려면 new 해야함
	//3. DI사용
	//4. DI 할 객체가 new 되어있어야함
	

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
