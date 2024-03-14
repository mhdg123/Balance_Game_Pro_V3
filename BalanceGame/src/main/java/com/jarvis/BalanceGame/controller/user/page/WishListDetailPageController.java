//package com.jarvis.BalanceGame.controller.user.page;
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
//import jakarta.servlet.http.HttpSession;
//
//@Controller
//public class WishListDetailPageController {
//
//	@Autowired
//	private QuestionService questionService;
//	
//	@RequestMapping("/wishListDetailPage")
//	public String WishListDetailPageController(QuestionDTO qDTO, Model model, HttpSession session) {
//		String loginId = (String)session.getAttribute("loginId");
//		int qId = Integer.parseInt(request.getParameter("qId"));
//		
//		qDTO.setqId(qId);
//		qDTO.setLoginId(loginId);
//		qDTO.setSearchCondition("문제상세조회");
//		System.out.println("qId: " + qId);
//		System.out.println("loginId" + loginId);
//		qDTO = questionService.selectOne(qDTO);
//		
//		if (qDTO == null) {
//			model.addAttribute("status", "fail");
//			model.addAttribute("msg", "해당 데이터가 없습니다");
//			model.addAttribute("redirect", "wishListPage.do");
//			return "alert";
//		}
//
//		model.addAttribute("qDTO", qDTO);
//		
//		return "wishListDetail";
//	}
//	
//	
//}