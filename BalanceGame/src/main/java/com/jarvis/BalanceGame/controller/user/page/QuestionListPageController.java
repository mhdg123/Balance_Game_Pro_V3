package com.jarvis.BalanceGame.controller.user.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.QuestionService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class QuestionListPageController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/questionListPage")
	public String titleLisgtPageControllter(QuestionDTO qDTO, Model model, HttpSession session) {
		
		qDTO.setSearchCondition("viewAllOfQuestionList");
		qDTO.setWriter((String)session.getAttribute("loginId"));
		List<QuestionDTO> datas = questionService.selectAll(qDTO);
		System.out.println(datas);
		
		if(datas != null) {
			model.addAttribute("qDatas", datas);
		}else {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "등록된 문제가 없습니다.");
			model.addAttribute("redirect", "");
			return "alert";
		}
		
		return "user/questionList";
	}
}