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
		
		System.out.println("승인할 문제 번호 : " + qDTO.getQuestionId());
		qDTO.setSearchCondition("approveQuestion");
		
		boolean flag = questionService.update(qDTO);
		
		System.out.println("문제 승인 한 결과 데이터 : " + qDTO);
		if(!flag) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "실패했습니다");
			model.addAttribute("redirect", "/admin/adminPage");
			return "alert";
			
		}
		model.addAttribute("status", "success");
		model.addAttribute("msg", "성공했습니다");
		model.addAttribute("redirect", "/admin/questionManagementPage");
		return "alert";
	}
}