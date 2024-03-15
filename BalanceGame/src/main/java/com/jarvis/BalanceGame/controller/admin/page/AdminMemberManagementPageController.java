package com.jarvis.BalanceGame.controller.admin.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminMemberManagementPageController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/memberManagementPage")
	public String adminMemberManagementPageController(MemberDTO mDTO, Model model) {
		
		mDTO.setSearchCondition("전체조회");
		List<MemberDTO> mdatas = memberService.selectAll(mDTO);
		System.out.println("member" + mdatas);
		
		if (mdatas == null) {
			model.addAttribute("status", "fail");
			model.addAttribute("fail", "회원이 존재하지 않습니다.");
			model.addAttribute("redirect", "adminPage");
			return "alert";
		}
		model.addAttribute("member", mdatas);
		return "admin/adminMemberManagement";
	}
		
}