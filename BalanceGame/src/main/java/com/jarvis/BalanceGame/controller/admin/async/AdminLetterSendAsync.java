package com.jarvis.BalanceGame.controller.admin.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/adminLetterSendAsync")
	public @ResponseBody String adminLetterSendAsync(LetterDTO lDTO, HttpSession session) {
		
		String loginId = (String)session.getAttribute("loginId");
		
		String recipient = lDTO.getSender();
		
		lDTO.setSender(loginId);
		lDTO.setLoginId(recipient);
		
		boolean flag = letterService.insert(lDTO);
		
		if(!flag) {
			return "fail";
		}
		
		return "success";
	}
	
	
}
