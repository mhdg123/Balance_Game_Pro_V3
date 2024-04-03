package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.service.LetterService;

@Controller
@RequestMapping("/user")
public class LetterDetailPageController {

	@Autowired
	private LetterService letterService;
	
	@GetMapping("/letterDetailPage")
	public String letterDetailPageController(LetterDTO lDTO, Model model) {
		lDTO.setSearchCondition("updateReadStatus");
		letterService.update(lDTO);
		lDTO.setSearchCondition("viewOneMessage");
		lDTO = letterService.selectOne(lDTO);
		
		
		model.addAttribute("letterData",lDTO);
		
		return "user/letterDetail";
	}
	
}
