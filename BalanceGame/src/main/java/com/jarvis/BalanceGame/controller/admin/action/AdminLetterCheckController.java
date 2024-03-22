package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.service.LetterService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminLetterCheckController {

	@Autowired
	private LetterService letterService;
	
	@GetMapping("/adminLetterCheck")
	public String adminLetterCheckController(LetterDTO lDTO, Model model, HttpSession session) {
		
		String loginId = (String)session.getAttribute("loginId");
		
		lDTO.setLoginId(loginId);
		letterService.update(lDTO);
		
		return "admin/adminLetterManagement";
	}
}
