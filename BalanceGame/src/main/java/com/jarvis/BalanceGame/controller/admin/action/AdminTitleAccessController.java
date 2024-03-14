package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.QuestionService;

@Controller
public class AdminTitleAccessController {

	@Autowired
	private QuestionService questionService;
	
	@RequestMapping("/")
	public String adminTitleAccessController(QuestionDTO qDTO, Model model) {
		
		qDTO.setSearchCondition("승인");
		
		boolean flag = questionService.update(qDTO);
		if(!flag) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "실패했습니다");
			model.addAttribute("redirect", "adminTitleAccessPage");
			return "alert";
			
		}
		model.addAttribute("status", "success");
		model.addAttribute("msg", "성공했습니다");
		model.addAttribute("redirect", "adminTitleAccessPage");
		return "alert";
	}
}