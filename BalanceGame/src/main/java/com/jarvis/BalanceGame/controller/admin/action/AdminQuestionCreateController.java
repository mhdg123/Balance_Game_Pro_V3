package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.QuestionService;

import jakarta.servlet.http.HttpSession;
//문제생성
	//관리자페이지에서 문제를 작성
	//뷰에서 문제를 작성하면 parameter값으로 받아옴 
	//해당 DTO에 set함 
	//작성한 것을 모델의 insert함
@Controller
@RequestMapping("/admin")
public class AdminQuestionCreateController {

	@Autowired
	private QuestionService questionService;
	
	
	@GetMapping("/TitleCreate")
	public String adminTitleCreateController(QuestionDTO qDTO, Model model, HttpSession session) {
		
		qDTO.setSearchCondition("관리자문제생성");
		
		boolean flag = questionService.insert(qDTO);
		if(!flag) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "문제출제에 실패했습니다");
			model.addAttribute("redirect", "/adminMain");
			return "/alert";
		}
		model.addAttribute("status", "success");
		model.addAttribute("msg", "문제출제에 성공했습니다");
		model.addAttribute("redirect", "/adminMain");
		
		
		return "/alert";
	}
}