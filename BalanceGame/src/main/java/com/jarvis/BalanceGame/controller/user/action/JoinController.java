package com.jarvis.BalanceGame.controller.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

@Controller
public class JoinController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/join")
	public String JoinController(MemberDTO mDTO, Model model) {
		model.addAttribute("UTF-8");
		mDTO.setSearchCondition("회원가입");

		if (!memberService.insert(mDTO)) {
			
			model.addAttribute("status", "sussess");
			model.addAttribute("msg", mDTO.getName() + "님 환영합니다");
			model.addAttribute("redirect","/");
			model.addAttribute("msg",  "오류 발생");
			
			return "alert";
		}
		
		model.addAttribute("status", "fail");
		model.addAttribute("redirect","/join");
		model.addAttribute("msg",  "오류가 발생하였습니다.");
		return "alert";
		
	}

}