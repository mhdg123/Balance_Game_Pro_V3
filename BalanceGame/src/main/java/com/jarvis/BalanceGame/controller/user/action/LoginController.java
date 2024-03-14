package com.jarvis.BalanceGame.controller.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/login")
	public String LoginController(MemberDTO mDTO, Model model,HttpSession session) {
		
		mDTO.setSearchCondition("로그인");
		memberService.selectOne(mDTO);
		mDTO = memberService.selectOne(mDTO);
		if (memberService != null) {
			if ("ADMIN".equals(mDTO.getRole())) {
				model.addAttribute("msg","관리자 로그인 완료");
				model.addAttribute("status", "success");
				session.setAttribute("loginId", mDTO.getLoginId());
				// memberService.getLoginId()
				model.addAttribute("msg", mDTO.getLoginId() + " 관리자님 로그인 하셨습니다.");
				model.addAttribute("redirect", "/adminPage");
				return "alert";
				
			} else {
				// 로그인 성공
				model.addAttribute("status", "success");
				session.setAttribute("loginId", mDTO.getLoginId());
				model.addAttribute("msg", mDTO.getLoginId() + "님 로그인 하셨습니다.");
				model.addAttribute("redirect", "/");
				return "alert";
			}
		}
			// 로그인 실패
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "로그인 정보가 틀렸습니다 다시 확인해주세요");
			model.addAttribute("redirect", "/login");
			return "alert";

	}
}