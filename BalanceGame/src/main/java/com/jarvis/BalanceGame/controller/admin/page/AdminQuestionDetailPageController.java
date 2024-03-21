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
public class AdminQuestionDetailPageController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/questionDetailPage")
	public String adminTitleDetailPageController(QuestionDTO qDTO, Model model) {
		System.out.println("관리자 문제 상세페이지 이동시 문제PK 데이터 :  " + qDTO.getQuestionId());
		qDTO.setSearchCondition("adminQuestionDetail");
		qDTO = questionService.selectOne(qDTO);
		System.out.println("관리자 문제 상세페이지 데이터 : " + qDTO);
		System.out.println("관리자 문제 출제 상태 값 : " + qDTO.getQuestionAccess() );
		
		if(qDTO == null) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "해당 데이터가 없습니다");
			model.addAttribute("redirect", "/admin/questionManagementPage");
			return "alert";
			
		}
		model.addAttribute("questionData", qDTO);
		return "admin/adminQuestionDetail";
	}
	
}