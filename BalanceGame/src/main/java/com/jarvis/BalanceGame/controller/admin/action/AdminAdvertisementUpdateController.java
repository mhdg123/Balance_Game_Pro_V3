package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jarvis.BalanceGame.model.dto.AdvertisementDTO;
import com.jarvis.BalanceGame.service.AdvertisementService;

@Controller
@RequestMapping("/admin")
public class AdminAdvertisementUpdateController {

	@Autowired
	private AdvertisementService advertisementService;
	
	@PostMapping("/adminAdvertisementUpdate")
	public String adminAdvertisementUpdateController(AdvertisementDTO aDTO, Model model, @RequestParam("advertisementImgOriginal") String originalImg) {
		System.out.println("관리자 광고 수정 파리미터 데이터 : " + aDTO);
		System.out.println("관링자 광고 수정 원본 이미지 데이터 :  " + originalImg);
		aDTO.setSearchCondition("adModification");
		if(aDTO.getAdvertisementImg() == "") {
			System.out.println("원본 데이터 넣어주기 ");
			aDTO.setAdvertisementImg(originalImg);
		}
		boolean flag = 	advertisementService.update(aDTO);
		if (!flag) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "광고수정 실패했습니다");
			model.addAttribute("redirect", "/admin/adminAdvertisementManagementPage");
			return "alert";
		}
		model.addAttribute("status", "success");
		model.addAttribute("msg", "광고수정 성공했습니다");
		model.addAttribute("redirect", "/admin/adminAdvertisementManagementPage");

		return "alert";
		
	}
}
