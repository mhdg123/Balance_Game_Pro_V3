package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.QuestionService;

@Controller
@RequestMapping("/admin")
public class AdminQuestionAccessController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/questionAccess")
	public String adminTitleAccessController(QuestionDTO qDTO, Model model) {
		
		qDTO.setSearchCondition("승인");
		
		boolean flag = questionService.update(qDTO);
		if(!flag) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "실패했습니다");
			model.addAttribute("redirect", "adminMain");
			return "alert";
			
		}
		model.addAttribute("status", "success");
		model.addAttribute("msg", "성공했습니다");
		model.addAttribute("redirect", "adminMain");
		return "alert";
	}
}