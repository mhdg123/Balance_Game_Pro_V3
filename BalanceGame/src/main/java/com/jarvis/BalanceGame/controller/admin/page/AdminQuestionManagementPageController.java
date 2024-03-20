package com.jarvis.BalanceGame.controller.admin.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.QuestionService;

@Controller
@RequestMapping("/admin")
public class AdminQuestionManagementPageController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/questionManagementPage")
	public String adminTitleManagementPageController(QuestionDTO qDTO, Model model) {
		
		qDTO.setSearchCondition("adminViewAllOfApprovedQuestions");
		qDTO.setQuestionAccess("T");
		
		
		List<QuestionDTO> qdatas_t = questionService.selectAll(qDTO);
		
		System.out.println("questionDatas" + qdatas_t);
		if(qdatas_t == null) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "해당 데이터가 없습니다");
			model.addAttribute("redirect", "adminPage");
			return "alert";
		}
		model.addAttribute("questionDatas", qdatas_t);
		System.out.println("questionDatas" + qdatas_t);
		return "admin/adminquestionManagement";
	}
}

