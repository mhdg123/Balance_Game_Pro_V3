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
public class AdminQuestionUpdateController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/TitleUpdate")
	public String adminTitleUpdateController(QuestionDTO qDTO, Model model) {
		
		qDTO.setSearchCondition("updateQuestion");
		
		boolean flag = questionService.update(qDTO);
		if(!flag) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "실패했습니다");
			model.addAttribute("redirect", "adminMain");
			return "alert";
		}
		model.addAttribute("status", "success");
		model.addAttribute("msg", "수정되었습니다");
		model.addAttribute("redirect", "adminMain");
		return "alert";

	}
}