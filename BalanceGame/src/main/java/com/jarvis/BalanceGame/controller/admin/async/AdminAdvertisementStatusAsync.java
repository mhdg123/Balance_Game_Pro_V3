package com.jarvis.BalanceGame.controller.admin.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.AdvertisementDTO;
import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.service.AdvertisementService;
import com.jarvis.BalanceGame.service.LetterService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminAdvertisementStatusAsync {

	@Autowired
	private AdvertisementService advertisementService;
	
	@PostMapping("/advertisementStatusAsync")
	public @ResponseBody String adminAdvertisementStatusAsync(AdvertisementDTO aDTO) {
		System.out.println("광고 보임 숨김 비동기 처리 기능 ");
		aDTO.setSearchCondition("adShowAndHide");
		if(!advertisementService.update(aDTO)) {
			System.out.println("광고 노출 상태 변경 오류");
			return "fail";
		}
		System.out.println("광고 노출 상태 변경 성공");
		return "success";
	}
	
	
}
