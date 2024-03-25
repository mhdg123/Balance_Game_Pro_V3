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
public class AdminAdvertisementDetailPageController {

	@Autowired
	private AdvertisementService advertisementService;
	
	@GetMapping("/adminAdvertisementDetailPage")
	public String adminAdvertisementManagementController(AdvertisementDTO aDTO, Model model) {
		System.out.println("관리자 광고 상세 페이지 이동");

		aDTO.setSearchCondition("adViewOne");
		AdvertisementDTO adData = advertisementService.selectOne(aDTO);
		System.out.println("관리자 등록된 광고 데이터 : " + adData);
		model.addAttribute("adData", adData);
		return "admin/adminAdvertisementDetail";
	}
	
}
