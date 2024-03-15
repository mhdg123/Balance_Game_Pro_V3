package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.QuestionService;
//한글코딩
	//모델에서 사용자가 올리는 순간 기본값은 false로 승인되지 않게 해놈
	//그럼 거절이유를 적어서 사용자에게 보내주어야함 
	//이 거절을 하는 action이 필요가 있나?

@Controller
@RequestMapping("/admin")
public class AdminQuestionRefuseController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/TitleRefuse")
	public String adminTitleRefuseController(QuestionDTO qDTO, Model model) {
		
		
		boolean flag = questionService.delete(qDTO);
		if(!flag) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "실패했습니다");
			model.addAttribute("redirect", "adminMain");
			return "alert";
		}
		model.addAttribute("status", "success");
		model.addAttribute("msg", "거절했습니다");
		model.addAttribute("redirect", "adminMain");
		return "alert";
	}
	
}
