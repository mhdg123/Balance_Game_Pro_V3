package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class ShopPageController {

	@GetMapping("/shop")
	public String shopPageController() {
		System.out.println("상점 페이지 이동");
		
		return "user/shop";
	}
}
