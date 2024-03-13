package com.jarvis.BalanceGame.controller.admin.page;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

@Controller
public class AdminMemberManagementPageController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/adminMemberManagementPage")
	public String AdminMemberManagementPageController(MemberDTO mDTO, Model model) {
		
		mDTO.setSearchCondition("전체조회");
		ArrayList<MemberDTO> mdatas = memberService.selectAll(mDTO);
		System.out.println("member" + mdatas);
		
		if (mdatas == null) {
			model.addAttribute("status", "fail");
			model.addAttribute("fail", "회원이 존재하지 않습니다.");
			model.addAttribute("redirect", "adminPage.do");
			return "alert";
		}
		model.addAttribute("member", mdatas);
		return "adminMemberManagement";
	}
		
}