package com.jarvis.BalanceGame.controller.admin.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dao.AdvertisementDAO;
import com.jarvis.BalanceGame.model.dto.AdvertisementDTO;
import com.jarvis.BalanceGame.model.dto.ItemDTO;
import com.jarvis.BalanceGame.service.AdvertisementService;

@Controller
@RequestMapping("/admin")
public class AdminAdvertisementManagementPageController {

	@Autowired
	private AdvertisementService advertisementService;
	
	@GetMapping("/adminAdvertisementManagementPage")
	public String adminCreateTitlePageController(AdvertisementDTO aDTO, Model model) {
		System.out.println("관리자 광고 관리 페이지 이동");
		List<AdvertisementDTO> adDatas = advertisementService.selectAll(aDTO);
		System.out.println("관리자 등록된 아이템 데이터 : " + adDatas);
		model.addAttribute("adDatas", adDatas);
		return "admin/adminAdvertisementManagement";
	}
	
}
