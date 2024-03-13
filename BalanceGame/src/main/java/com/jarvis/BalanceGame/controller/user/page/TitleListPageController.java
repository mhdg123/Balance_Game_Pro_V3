package com.jarvis.BalanceGame.controller.user.page;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.QuestionService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TitleListPageController {

	@Autowired
	private QuestionService questionService;
	
	@RequestMapping("/titleListPage")
	public String TitleLisgtPageControllter(QuestionDTO qDTO, Model model, HttpSession session) {
		
		qDTO.setSearchCondition("문제전체조회");
		qDTO.setLoginId((String)session.getAttribute("loginId"));
		ArrayList<QuestionDTO> datas = questionService.selectAll(qDTO);
		
		System.out.println(datas);
		
		if(datas != null) {
			model.addAttribute("qDatas", datas);
		}else {
			model.addAttribute("status", "success");
			model.addAttribute("msg", "등록된 문제가 없습니다.");
			model.addAttribute("redirect", "main.do");
			return "alert";
		}
		
		return "titleList";
	}
}