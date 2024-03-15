//package com.jarvis.BalanceGame.controller.admin.page;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.jarvis.BalanceGame.model.dto.LetterDTO;
//import com.jarvis.BalanceGame.service.LetterService;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminLetterDetailPageController {
//
//	@Autowired
//	private LetterService letterService;
//	
//	@GetMapping("/letterDetailPageAction")
//	public String adminSuggestionDetailPageController(LetterDTO lDTO, Model model) {
//		
//		lDTO = letterService.selectOne(lDTO);
//		
//		if(lDTO == null) {
//			model.addAttribute("status", "fail");
//			model.addAttribute("msg", "해당 데이터가 없습니다");
//			model.addAttribute("redirect", "adminLetterDetail");
//			return "alert";
//		}
//		
//		model.addAttribute("lDTO", lDTO);
//
//		return "admin/adminLetterDetail";
//	}
//}
//
//
