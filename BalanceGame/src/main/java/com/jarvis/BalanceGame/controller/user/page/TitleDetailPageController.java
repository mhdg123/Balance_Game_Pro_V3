package com.jarvis.BalanceGame.controller.user.page;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.CommentDTO;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.CommentService;
import com.jarvis.BalanceGame.service.QuestionService;

@Controller
public class TitleDetailPageController {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/")
	public String TitleDetailPageController(QuestionDTO qDTO, CommentDTO cDTO, Model model) {
		
		qDTO.setSearchCondition("문제상세조회");
		qDTO.setLoginId(request.getParameter("writer")); // 파라미터 : 작성자x, 로그인ID [조지훈]
		qDTO.setqId(Integer.parseInt(request.getParameter("qid")));
		
		questionService.selectOne(qDTO);
		
		cDTO.setSearchCondition("질문댓글조회");
		cDTO.setqId(Integer.parseInt(request.getParameter("qid")));
		ArrayList<cDTO> commentDatas =  questionService.selectAll(cDTO);
		
		if(questionService != null) {
			model.addAttribute("qData", questionService);
			model.addAttribute("cDatas", commentDatas);
		}else {
			model.addAttribute("qData", questionService);
			model.addAttribute("cDatas", commentDatas);
		}
		return "titleDetail";
	}
}

