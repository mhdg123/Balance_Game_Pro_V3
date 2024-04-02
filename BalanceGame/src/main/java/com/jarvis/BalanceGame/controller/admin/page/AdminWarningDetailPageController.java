package com.jarvis.BalanceGame.controller.admin.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.WarningDTO;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.WarningService;

@Controller
@RequestMapping("/admin")
public class AdminWarningDetailPageController {

	@Autowired
	private WarningService warningService;
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/warningDetailPage")
	public String adminAdvertisementManagementController(WarningDTO aDTO,MemberDTO mDTO, Model model) {
		System.out.println("관리자 신고 상세페이지 이동");
		
		mDTO.setSearchCondition("viewOne");
		memberService.selectOne(mDTO);
		
		warningService.selectOne(aDTO);
		
		return "admin/adminWarningDetail";
	}
	
}
