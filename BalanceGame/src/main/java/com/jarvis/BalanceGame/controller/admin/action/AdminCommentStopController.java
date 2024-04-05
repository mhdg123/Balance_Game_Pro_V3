package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminCommentStopController {
	
	@Autowired
	private MemberService memberService;
	//commentStatus


	@GetMapping("/adminCommentStopController")
	public String adminCommentStopController(MemberDTO mDTO, Model model) {
		
		mDTO.setSearchCondition("viewOne");
		memberService.selectOne(mDTO);
		
		if(mDTO.getWriteStatus()=="T") {
			mDTO.setSearchCondition("updateCommentStatusF");
			memberService.update(mDTO);
		}
		if(mDTO.getWriteStatus()=="F") {
			mDTO.setSearchCondition("updateCommentStatusT");
			memberService.update(mDTO);
		}
		
		model.addAttribute("status", "success");
		model.addAttribute("msg", "상태변경 성공했습니다");
		model.addAttribute("redirect", "/admin/adminWarningManagementPage");
		
		return "alert";
	}
}
