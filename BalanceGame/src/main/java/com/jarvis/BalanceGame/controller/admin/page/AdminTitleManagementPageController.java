//package com.jarvis.BalanceGame.controller.admin.page;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.jarvis.BalanceGame.model.dto.QuestionDTO;
//import com.jarvis.BalanceGame.service.QuestionService;
//
//@Controller
//public class AdminTitleManagementPageController {
//
//	@Autowired
//	private QuestionService questionService;
//	
//	@RequestMapping("/adminTitleManagementPage")
//	public String AdminTitleManagementPageController(QuestionDTO qDTO, Model model) {
//		
//		qDTO.setSearchCondition("관리자문제조회");
//		qDTO.setqAccess("T");
//		
//		
//		List<QuestionDTO> qdatas_t = questionService.selectAll(qDTO);
//		
//		System.out.println("qdatas_t" + qdatas_t);
//		if(qdatas_t == null) {
//			model.addAttribute("status", "fail");
//			model.addAttribute("msg", "해당 데이터가 없습니다");
//			model.addAttribute("redirect", "adminPage.do");
//			return "alert";
//		}
//		model.addAttribute("qdatas_t", qdatas_t);
//		System.out.println("qdatas_t" + qdatas_t);
//		return "adminTitleManagement";
//	}
//}
//
