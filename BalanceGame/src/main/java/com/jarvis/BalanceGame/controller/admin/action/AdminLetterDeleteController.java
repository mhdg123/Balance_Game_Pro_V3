//package com.jarvis.BalanceGame.controller.admin.action;
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
//public class AdminLetterDeleteController {
//
//	@Autowired
//	private LetterService letterService;
//	
//	
//	@GetMapping("/LetterDelete")
//	public String adminLetterDeleteController(LetterDTO lDTO, Model model) {
//		
//		boolean flag = letterService.delete(lDTO);
//		
//		if(!flag) {
//			model.addAttribute("status", "fail");
//			model.addAttribute("msg", "실패했습니다");
//			model.addAttribute("redirect", "adminMain");
//			return "alert";
//		}
//		model.addAttribute("status", "success");
//		model.addAttribute("msg", "삭제했습니다");
//		model.addAttribute("redirect", "adminMain");
//		return "alert";
//	}
//}
//
//
