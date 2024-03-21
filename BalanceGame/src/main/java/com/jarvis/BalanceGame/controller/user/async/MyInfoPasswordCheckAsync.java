package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class MyInfoPasswordCheckAsync {

	@Autowired
	private MemberService memberService;
	
	@PostMapping("/myInfoPasswordCheckAsync")
	public @ResponseBody String myInfoPasswordCheckAsync(MemberDTO mDTO,  @RequestParam("password") String password,Model model, HttpSession session) {
		mDTO.setSearchCondition("login");
		String loginId = (String)session.getAttribute("loginId");
		mDTO.setLoginId(loginId);
		mDTO.setMemberPassword(password);
		mDTO = memberService.selectOne(mDTO);
		
		if(mDTO == null) {
			return "fail";
		}

		return "success";
	}
}
