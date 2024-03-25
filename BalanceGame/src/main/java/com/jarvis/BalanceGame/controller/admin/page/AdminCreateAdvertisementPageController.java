package com.jarvis.BalanceGame.controller.admin.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.AdvertisementDTO;
import com.jarvis.BalanceGame.service.AdvertisementService;

@Controller
@RequestMapping("/admin")
public class AdminCreateAdvertisementPageController {

	@Autowired
	private AdvertisementService advertisementService;
	
	@GetMapping("/adminCreateAdvertisementPage")
	public String adminCreateTitlePageController(AdvertisementDTO aDTO, Model model) {
		System.out.println("관리자 광고 생성 페이지 이동");
		// 광고 마지막 PK 데이터 필요
		return "admin/adminCreateAdvertisement";
	}
	
}
