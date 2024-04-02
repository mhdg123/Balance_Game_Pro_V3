package com.jarvis.BalanceGame.controller.admin.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.AdvertisementDTO;
import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.model.dto.WarningDTO;
import com.jarvis.BalanceGame.service.AdvertisementService;
import com.jarvis.BalanceGame.service.LetterService;
import com.jarvis.BalanceGame.service.WarningService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminWarningManagementPageController {
	
	@Autowired
	private LetterService letterService;

	
	@GetMapping("/warningManagementPage")
	public String adminAdvertisementManagementController(WarningDTO aDTO, Model model, LetterDTO lDTO, HttpSession session) {
		System.out.println("관리자 신고관리 페이지 이동");
		String loginId = (String)session.getAttribute("loginId");
		if(loginId == null) {
			loginId = "admin"; // 관리자 아이디 고정 
		}
		lDTO.setLoginId(loginId);
		lDTO.setSearchCondition("viewAllReportMessageAdmin");
		List<LetterDTO> lDatas = letterService.selectAll(lDTO);
		System.out.println("신고 내역 데이터 :  " + lDatas);
		model.addAttribute("letterDatas", lDatas);
		

		return "admin/adminWarningManagement";
	}
	
}
