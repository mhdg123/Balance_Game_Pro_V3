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
		//  (아이템  마지막 PK값 데이터 searchCondition 사용해서 가져오기 dao추가됨)
		return "admin/adminCreateItem";
	}
	
}
