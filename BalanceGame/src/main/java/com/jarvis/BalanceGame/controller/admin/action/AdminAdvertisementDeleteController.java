package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.AdvertisementDTO;
import com.jarvis.BalanceGame.service.AdvertisementService;

@Controller
@RequestMapping("/admin")
public class AdminAdvertisementDeleteController {

	@Autowired
	private AdvertisementService advertisementService;
	
	@GetMapping("/adminAdvertisementDelete")
	public String adminAdvertisementDeleteController(AdvertisementDTO aDTO, Model model) {

		boolean flag = 	advertisementService.delete(aDTO);

		if (!flag) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "광고삭제 실패했습니다");
			model.addAttribute("redirect", "admin/adminPage");
			return "alert";
		}
		model.addAttribute("status", "success");
		model.addAttribute("msg", "광고삭제 성공했습니다");
		model.addAttribute("redirect", "admin/adminPage");

		return "alert";
		
	}
	
}