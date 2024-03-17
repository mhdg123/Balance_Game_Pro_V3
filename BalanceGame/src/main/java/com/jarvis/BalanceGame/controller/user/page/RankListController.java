package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class RankListController {

	@GetMapping("/rankListPage")
	public String rankListPage() {
		System.out.println("랭킹페이지 이동");
		return "user/rankList";
	}
}
