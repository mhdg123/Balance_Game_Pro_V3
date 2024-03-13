package com.jarvis.BalanceGame.controller.admin.page;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminSuggestionDetailPageController {

	@Autowired
	private SuggestionService suggestionService;
	
	@RequestMapping("/adminSuggestionDetailPageAction")
	public String AdminSuggestionDetailPageController(SuggestionDTO sugDTO, Model model) {
		
		sugDTO.setSugId(Integer.parseInt(request.getParameter("sugId")));
		sugDTO = suggestionService.selectOne(sugDTO);
		
		if(sugDTO == null) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "해당 데이터가 없습니다");
			model.addAttribute("redirect", "adminSuggestionDetail.jsp");
			return "alert";
		}
		
		model.addAttribute("sugDTO", sugDTO);

		return "adminSuggestionDetail";
	}
}