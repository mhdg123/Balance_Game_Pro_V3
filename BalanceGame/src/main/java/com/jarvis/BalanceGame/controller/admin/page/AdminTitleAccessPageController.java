package com.jarvis.BalanceGame.controller.admin.page;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;

@Controller
public class AdminTitleAccessPageController {

	@Autowired
	private QussestionService qussestionService;
	
	
	@RequestMapping
	public String AdminTitleAccessPageController(QuestionDTO qDTO, Model model) {
		
		qDTO.setSearchCondition("관리자문제조회");
		
		qDTO.setqAccess("F");
		
		ArrayList<QuestionDTO> qdatas_f = qDAO.selectAll(qDTO);
		
		System.out.println("qdatas_f"+qdatas_f);
		
		if(qdatas_f == null) {	
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "해당 데이터가 없습니다");
			model.addAttribute("redirect", "adminPage.do");
			return "alert";
		}
		
		model.addAttribute("qdatas_f", qdatas_f);

		return "adminTitleAccess";
	}
}

