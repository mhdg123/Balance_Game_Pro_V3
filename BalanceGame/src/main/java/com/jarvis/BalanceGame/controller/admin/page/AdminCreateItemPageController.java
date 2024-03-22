package com.jarvis.BalanceGame.controller.admin.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminCreateItemPageController {

	@GetMapping("/adminCreateItemPage")
	public String adminCreateTitlePageController() {
		System.out.println("관리자 아이템 생성 페이지 이동");
		return "admin/adminCreateItem";
	}
	
}
