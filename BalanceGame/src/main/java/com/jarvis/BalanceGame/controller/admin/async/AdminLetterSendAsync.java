package com.jarvis.BalanceGame.controller.admin.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.service.LetterService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminLetterSendAsync {

	@Autowired
	private LetterService letterService;
	
	// 관리자가 편지를 유저에게 보내는 기능
	@PostMapping("/adminLetterSendAsync")
	public @ResponseBody String adminLetterSendAsync(LetterDTO lDTO, HttpSession session) {
		System.out.println("답변보내기 기능 ");
		String loginId = (String)session.getAttribute("loginId");
		// 수신자를 설정하고, 검색 조건을 설정하여 편지를 작성
		String recipient = lDTO.getSender();
		lDTO.setSender(loginId);
		lDTO.setSearchCondition("writeLetterAdmin");
		lDTO.setLoginId(recipient);
		boolean flag = letterService.insert(lDTO);
		if(!flag) {
			return "fail";
		}
		return "success";
	}
	
	
}
