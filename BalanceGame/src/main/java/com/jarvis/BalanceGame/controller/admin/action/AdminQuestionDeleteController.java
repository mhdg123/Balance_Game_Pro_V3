package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.QuestionService;

@Controller
@RequestMapping("/admin")
public class AdminQuestionDeleteController {

	@Autowired
	private QuestionService questionService;
	
	// 관리자가 문제를 삭제하는 기능
	@PostMapping("/adminQuestionDelete")
	public String adminTitleDeleteController(QuestionDTO qDTO, Model model) {
		
		// 문제 삭제 실행
		boolean flag = questionService.delete(qDTO);
		
		// 실패 처리
		if(!flag) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "실패했습니다");
			model.addAttribute("redirect", "/admin/questionManagementPage");
			return "alert";
		}
		// 성공 처리
		model.addAttribute("status", "success");
		model.addAttribute("msg", "문제를 삭제했습니다");
		model.addAttribute("redirect", "/admin/questionManagementPage");
		return "alert";

	}
}

