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
public class AdminQuestionAccessPageController {

	@Autowired
	private QuestionService questionService;
	
	
	@GetMapping("/questionAccessPage")
	public String adminTitleAccessPageController(QuestionDTO qDTO, Model model) {
		
		qDTO.setSearchCondition("관리자문제조회");
		
		qDTO.setQuestionAccess("F");
		
		List<QuestionDTO> qdatas_f = questionService.selectAll(qDTO);
		
		System.out.println("qdatas_f"+qdatas_f);
		
		if(qdatas_f == null) {	
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "해당 데이터가 없습니다");
			model.addAttribute("redirect", "adminQuestionAccess");
			return "alert";
		}
		
		model.addAttribute("qdatas_f", qdatas_f);

		return "admin/adminQuestionAccess";
	}
}

