package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.service.LetterService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserLetterController {
	
	@Autowired
	private LetterService letterService;
	
	@PostMapping("/sendLetter")
	public String userSuggertionController(LetterDTO lDTO, Model model, HttpSession session) {
		
		String loginId = (String) session.getAttribute("loginId");
		lDTO.setLetterType("SUGGESTION");
		lDTO.setSearchCondition("writeLetterMember");
		lDTO.setSender(loginId); // 건의하는 유저 아이디
		lDTO.setLoginId("ADMIN");
		boolean flag = letterService.insert(lDTO);
		
		if (!flag) {
			model.addAttribute("msg", "전송에 실패했습니다");
			model.addAttribute("status", "failClose");
			return "alert";
		}
		
		model.addAttribute("status", "close");
		model.addAttribute("msg", "건의사항이 발송되었습니다.");
		return "user/index";
	}
}


