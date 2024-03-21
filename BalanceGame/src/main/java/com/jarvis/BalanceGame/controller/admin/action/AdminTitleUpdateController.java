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
public class AdminTitleUpdateController {

	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/titleUpdate")
	public String adminTitleUpdateController(QuestionDTO qDTO, Model model) {
		System.out.println("관리자 문제PK 파라미터 : " + qDTO.getQuestionId());
		System.out.println("관리자 문제 출제 유저 아이디 :  " + qDTO.getWriter());
		System.out.println("관리자 문제 제목 파라미터 : " + qDTO.getTitle());
		System.out.println("관리자 문제 답변A 파라미터 : " + qDTO.getAnswerA());
		System.out.println("관리자 문제 답변B 파라미터 : " + qDTO.getAnswerB());
		System.out.println("관리자 문제 설명 파라미터 : " + qDTO.getExplanation());
		System.out.println("관리자 문제 출제 수락 여부  파라미터 : " + qDTO.getQuestionAccess());
		System.out.println();
		Class<?> dataType = qDTO.getQuestionAccess().getClass();
		System.out.println("데이터 타입: " + dataType.getName());
		qDTO.setSearchCondition("updateQuestion");
		
		boolean flag = questionService.update(qDTO);
		if(!flag) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "실패했습니다");
			model.addAttribute("redirect", "adminMain");
			return "alert";
		}
		System.out.println("관리자 문제 수정 성공");
		model.addAttribute("status", "success");
		model.addAttribute("msg", "수정되었습니다");
		model.addAttribute("redirect", "adminMain");
		return "alert";

	}
}