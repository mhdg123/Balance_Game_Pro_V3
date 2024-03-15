//package com.jarvis.BalanceGame.controller.user.page;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.jarvis.BalanceGame.model.dto.CommentDTO;
//import com.jarvis.BalanceGame.model.dto.QuestionDTO;
//import com.jarvis.BalanceGame.service.CommentService;
//import com.jarvis.BalanceGame.service.QuestionService;
//
//@Controller
//@RequestMapping("/user")
//public class TitleDetailPageController {
//
//	@Autowired
//	private QuestionService questionService;
//	@Autowired
//	private CommentService commentService;
//	
//	@GetMapping("/questionDetailPage")
//	public String titleDetailPageController(QuestionDTO qDTO, CommentDTO cDTO, Model model) {
//		
//		qDTO.setSearchCondition("문제상세조회");
//
//		questionService.selectOne(qDTO);
//		
//		cDTO.setSearchCondition("질문댓글조회");
//		List<CommentDTO> commentDatas = questionService.selectAll(cDTO);
//		
//		if(questionService != null) {
//			model.addAttribute("qData", questionService);
//			model.addAttribute("cDatas", commentDatas);
//		}else {
//			model.addAttribute("qData", questionService);
//			model.addAttribute("cDatas", commentDatas);
//		}
//		return "user/aminquestionDetail";
//	}
//}
//


