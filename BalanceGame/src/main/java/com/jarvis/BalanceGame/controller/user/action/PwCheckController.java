package com.jarvis.BalanceGame.controller.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PwCheckController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/pwCheck")
	public String PwCheckController(MemberDTO mDTO, Model model,HttpSession session) {
		mDTO.setSearchCondition("2차인증");
		
		mDTO.setLoginId((String) session.getAttribute("loginId"));
		System.out.println(session.getAttribute("loginId"));
		
		memberService.selectOne(mDTO);
		
		if (memberService != null) {
			
			// 인증 성공
			model.addAttribute("status", "success");
			model.addAttribute("redirect", "myPage.do");
			model.addAttribute("msg", memberService.selectOne(mDTO).getName() + "님 인증 성공하였습니다.");
			
			return "/alert";	
		}
		
			// 인증실패	
		model.addAttribute("status", "fail");
		model.addAttribute("redirect", "/PwCheckAcion");
		model.addAttribute("msg","비밀번호가 맞지 않습니다 다시 확인해주세요");

		return "/alert";	
}
}