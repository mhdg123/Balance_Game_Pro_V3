package com.jarvis.BalanceGame.controller.admin.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.QuestionService;

@Controller
@RequestMapping("/admin")
public class AdminQuestionDetaileAccessPageController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/questionDetaileAccessPage")
	public String adminTitleDetaileAccessPageController(QuestionDTO qDTO, Model model) {
		
		qDTO.setSearchCondition("adminQuestionDetail");
		qDTO = questionService.selectOne(qDTO);
		
		if(qDTO == null) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "해당 데이터가 없습니다");
			model.addAttribute("redirect", "adminQuestionDetaileAccess");
			return "alret";
		}
		model.addAttribute("questionData", qDTO);
		return "admin/adminQuestionDetaileAccess";
	}
	
}