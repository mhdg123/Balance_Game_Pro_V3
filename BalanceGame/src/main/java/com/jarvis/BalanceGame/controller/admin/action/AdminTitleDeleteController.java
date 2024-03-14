package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.QuestionService;

@Controller
public class AdminTitleDeleteController {

	@Autowired
	private QuestionService questionService;
	
	@RequestMapping("/")
	public String adminTitleDeleteController(QuestionDTO qDTO, Model model) {
		
		boolean flag = questionService.delete(qDTO);
		if(!flag) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "실패했습니다");
			model.addAttribute("redirect", "adminTitleManagementPage");
			return "alert";
		}
		model.addAttribute("status", "success");
		model.addAttribute("msg", "문제를 삭제했습니다");
		model.addAttribute("redirect", "adminTitleManagementPage");
		return "alert";

	}
}

