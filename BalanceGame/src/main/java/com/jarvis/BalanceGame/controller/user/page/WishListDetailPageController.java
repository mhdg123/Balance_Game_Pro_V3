package com.jarvis.BalanceGame.controller.user.page;

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
public class WishListDetailPageController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/wishListDetailPage")
	public String wishListDetailPageController(QuestionDTO qDTO, Model model, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		
		
		qDTO.setWriter((String)session.getAttribute("Writer"));
		
		qDTO.setSearchCondition("문제상세조회");
		System.out.println("Writer" + loginId);
		qDTO = questionService.selectOne(qDTO);
		
		if (qDTO == null) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "해당 데이터가 없습니다");
			model.addAttribute("redirect", "/user/wishListPage");
			return "/alert";
		}

		model.addAttribute("qDTO", qDTO);
		
		return "/user/wishListDetail";
	}
	
	
}