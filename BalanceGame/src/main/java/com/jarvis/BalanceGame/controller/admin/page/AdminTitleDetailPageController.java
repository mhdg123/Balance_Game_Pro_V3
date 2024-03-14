//package com.jarvis.BalanceGame.controller.admin.page;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
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
//public class AdminTitleDetailPageController {
//
//	@Autowired
//	private QuestionService questionService;
//	
//	@RequestMapping("/adminTitleDetailPage")
//	public String AdminTitleDetailPageController(QuestionDTO qDTO, Model model) {
//		
//		int qid = Integer.parseInt(request.getParameter("qid"));
//		qDTO.setqId(qid);
//		qDTO.setSearchCondition("관리자문제상세조회");
//		qDTO = questionService.selectOne(qDTO);
//		
//		if(qDTO == null) {
//			model.addAttribute("status", "fail");
//			model.addAttribute("msg", "해당 데이터가 없습니다");
//			model.addAttribute("redirect", "adminTitleAccessPage.do");
//			return "alert";
//			
//		}
//		model.addAttribute("qDTO", qDTO);
//		return "adminTitleDetail";
//	}
//	
//}