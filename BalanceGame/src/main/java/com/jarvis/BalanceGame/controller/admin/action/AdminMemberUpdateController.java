package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminMemberUpdateController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/MemberUpdate")
	public String adminMemberUpdateController(MemberDTO mDTO, Model model, HttpSession session) {
		
		mDTO.setLoginId((String) session.getAttribute("loginId"));
		
		
		boolean myInfoUpdate = memberService.update(mDTO);
		if (myInfoUpdate) {
			// 내정보 변경 성공
			model.addAttribute("status", "success");
			model.addAttribute("msg", "정보가 수정되었습니다.");
			model.addAttribute("redirect", "adminMain");
			return "alert";
		}
		
			// 내정보 변경 실패
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "정보 변경에 실패하였습니다.");
			model.addAttribute("redirect", "adminMain");
			return "alert";

	}
	
}