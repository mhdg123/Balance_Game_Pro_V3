package com.jarvis.BalanceGame.controller.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

@Controller
@RequestMapping("/user")
public class JoinController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/join")
	public String joinController(MemberDTO mDTO, Model model) {
		mDTO.setSearchCondition("회원가입");

		if (memberService.insert(mDTO)) {
			System.out.println("회원가입 성공");
			model.addAttribute("status", "success");
			model.addAttribute("msg", mDTO.getName() + "님 환영합니다");
			model.addAttribute("redirect","/");
			return "alert";
		}
		
		model.addAttribute("status", "fail");
		model.addAttribute("redirect","join");
		model.addAttribute("msg",  "오류가 발생하였습니다.");
		return "alert";
		
	}
	
	
	@RequestMapping("/addressSearchApi")
	public String addressSearchApi() {
		System.out.println("주소api 페이지 실행");
		return "user/addressPopup";
	}

}