package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class MyPageController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/myInfoPage")
	public String myPageController(MemberDTO mDTO, Model model, HttpSession session) {
		
		mDTO.setLoginId((String)session.getAttribute("loginId"));
		mDTO.setSearchCondition("myInfo");
//		System.out.println(memberService.selectOne(mDTO).getLoginId());
		model.addAttribute("myPageData", memberService.selectOne(mDTO));
		
		return "user/myInfo";
	}
}