package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyPageController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/myPage")
	public String MyPageController(MemberDTO mDTO, Model model, HttpSession session) {
		
		mDTO.setLoginId((String)session.getAttribute("loginId"));
		mDTO.setSearchCondition("유저조회");
		memberService.selectOne(mDTO);
		System.out.println(memberService.getLoginId());
		model.addAttribute("myPageData", memberService);
		
		return "myPage";
	}
}