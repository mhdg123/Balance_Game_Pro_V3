package com.jarvis.BalanceGame.controller.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.QuestionService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MakeTitleController {
	@Autowired
	private QuestionService questionService;

	@RequestMapping("/makeTitle")
	public String MakeTitleController(QuestionDTO qDTO, Model model,HttpSession session) {
		qDTO.setSearchCondition("문제생성");
		qDTO.setLoginId((String) session.getAttribute("loginId")); // 로그인 아이디
		questionService.insert(qDTO);
		
		if (!questionService.insert(qDTO)) {
			model.addAttribute("status", "success");
			model.addAttribute("msg", "실패");
			model.addAttribute("redirect", "main.do");
			return "alert";
			
		}
		// 문제 출제 하기 성공
		model.addAttribute("status", "fail");
		model.addAttribute("msg", "실패");
		model.addAttribute("redirect", "makeTitlePage.do");
		return "alert";

	}
}