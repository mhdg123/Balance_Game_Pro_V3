package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jarvis.BalanceGame.model.dto.AnswerDTO;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.AnswerService;
import com.jarvis.BalanceGame.service.QuestionService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class AnswerAsync {

	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/answerAsync")
	public @ResponseBody String AnswerAsync(AnswerDTO aDTO, QuestionDTO qDTO, Model model, HttpSession session, Gson gson) {
		
		System.out.println("들어옴");
		aDTO.setLoginId((String)session.getAttribute("loginId"));
		
		aDTO.setSearchCondition("saveAnswer");
		
		if(answerService.insert(aDTO)) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		qDTO.setSearchCondition("questionDetail");
		qDTO.setWriter((String)session.getAttribute("loginId"));
		
		return gson.toJson(questionService.selectOne(qDTO));
	}
}