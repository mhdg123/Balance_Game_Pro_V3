package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.QuestionService;

@Controller
@RequestMapping("/admin")
public class AdminQuestionUpdateController {

	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/questionUpdate")
	public String adminTitleUpdateController(QuestionDTO qDTO, Model model) {
		System.out.println("관리자 문제PK 파라미터 : " + qDTO.getQuestionId());
		System.out.println("관리자 문제 출제 유저 아이디 :  " + qDTO.getWriter());
		System.out.println("관리자 문제 제목 파라미터 : " + qDTO.getTitle());
		System.out.println("관리자 문제 답변A 파라미터 : " + qDTO.getAnswerA());
		System.out.println("관리자 문제 답변B 파라미터 : " + qDTO.getAnswerB());
		System.out.println("관리자 문제 설명 파라미터 : " + qDTO.getExplanation());
		qDTO.setSearchCondition("updateQuestion");
		if(qDTO.getQuestionAccess() == null) {
			qDTO.setQuestionAccess("F");
		}
		boolean flag = questionService.update(qDTO);
		
		if(!flag) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "실패했습니다");
			model.addAttribute("redirect", "/admin/adminPage");
			return "alert";
		}
	
		System.out.println("관리자 문제 수정 성공");
		model.addAttribute("status", "success");
		model.addAttribute("msg", "수정되었습니다");
		model.addAttribute("redirect", "/admin/questionManagementPage");
		return "alert";

	}
}