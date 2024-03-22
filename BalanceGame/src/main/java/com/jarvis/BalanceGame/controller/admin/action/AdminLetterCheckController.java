package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.service.LetterService;

@Controller
@RequestMapping("/admin")
public class AdminLetterCheckController {

	@Autowired
	private LetterService letterService;
	
	@GetMapping("/adminLetterCheckController")
	public String adminLetterCheckController(LetterDTO lDTO, Model model) {
		lDTO.setLoginId("admin");
		letterService.update(lDTO);
		
		return "admin/adminLetterManagement";
	}
}
