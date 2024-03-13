package com.jarvis.BalanceGame.controller.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyPageUpdateController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/mypageUpdate")
	public String MyPageUpdateController(MemberDTO mDTO, Model model,HttpSession session) {
		model.addAttribute("UTF-8");
		mDTO.setLoginId((String)session.getAttribute("loginId"));
		mDTO.setSearchCondition("내정보변경");
		
		if(!memberService.update(mDTO)) {
			System.out.println("내정보 변경 실패");
			model.addAttribute("status", "fail");			
			model.addAttribute("msg", "정보 변경에 실패하였습니다.");
			model.addAttribute("redirect", "myPage.do");
			return "alert";
			
		}
		
			System.out.println("내정보 변경 성공");
			model.addAttribute("status", "success");			
			model.addAttribute("msg","정보변경 성공");
			model.addAttribute("redirect", "main.do");
			
		return "alert";
	}
	
}