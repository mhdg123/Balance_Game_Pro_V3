package com.jarvis.BalanceGame.controller.admin.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminCreateQuestionPageController {

	// 문제 생성 페이지로 이동
	@GetMapping("/adminMakeQuestionPage")
	public String adminCreateTitlePageController() {
		System.out.println("관리자 문제 출제 페이지 이동");
		return "admin/adminMakeQuestion";
	}
	
}
