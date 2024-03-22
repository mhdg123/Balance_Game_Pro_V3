package com.jarvis.BalanceGame.controller.admin.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.service.LetterService;

@Controller
@RequestMapping("/admin")
public class AdminLetterListPageController {

	@Autowired
	private LetterService letterService;
	
	@GetMapping("adminLetterListPageController")
	public String adminLetterListPageController(LetterDTO lDTO, Model model) {
		lDTO.setSearchCondition("viewAllMessage");
		List<LetterDTO> lDatas = letterService.selectAll(lDTO);
		
		model.addAttribute("letterDatas", lDatas);
		
		return "admin/adminLetterListPageController";
	}
}
