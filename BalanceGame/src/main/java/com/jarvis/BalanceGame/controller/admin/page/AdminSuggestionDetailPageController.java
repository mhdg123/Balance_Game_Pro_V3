//package com.jarvis.BalanceGame.controller.admin.page;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.jarvis.BalanceGame.model.dto.LetterDTO;
//import com.jarvis.BalanceGame.service.LetterService;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminSuggestionDetailPageController {
//
//	@Autowired
//	private LetterService letterService;
//	
//	@GetMapping("/adminSuggestionDetailPageAction")
//	public String AdminSuggestionDetailPageController(LetterDTO lDTO, Model model) {
//		
//		lDTO = letterService.selectOne(lDTO);
//		
//		if(lDTO == null) {
//			model.addAttribute("status", "fail");
//			model.addAttribute("msg", "해당 데이터가 없습니다");
//			model.addAttribute("redirect", "adminSuggestionDetail");
//			return "alert";
//		}
//		
//		model.addAttribute("lDTO", lDTO);
//
//		return "adminSuggestionDetail";
//	}
//}

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
