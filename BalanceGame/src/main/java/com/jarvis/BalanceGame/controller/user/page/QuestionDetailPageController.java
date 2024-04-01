package com.jarvis.BalanceGame.controller.user.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.AdvertisementDTO;
import com.jarvis.BalanceGame.model.dto.CommentDTO;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.AdvertisementService;
import com.jarvis.BalanceGame.service.CommentService;
import com.jarvis.BalanceGame.service.QuestionService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class QuestionDetailPageController {

	@Autowired
	private AdvertisementService advertisementService;
	
	@Autowired
	private QuestionService questionService;
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/questionDetailPage")
	public String titleDetailPageController(QuestionDTO qDTO, CommentDTO cDTO, Model model, HttpSession session, AdvertisementDTO aDTO) {
		
		aDTO.setSearchCondition("adRandomChoice");
		AdvertisementDTO adData = advertisementService.selectOne(aDTO);
		System.out.println("게임 페이지 광고 데이터 : " + adData );
		
		String loginId = (String) session.getAttribute("loginId");
		qDTO.setWriter(loginId);
		qDTO.setSearchCondition("questionDetail");
		
		qDTO = questionService.selectOne(qDTO);
		
		cDTO.setSearchCondition("questionComments");
		List<CommentDTO> commentDatas = commentService.selectAll(cDTO);
		
		if(questionService != null) {
			model.addAttribute("questionData", qDTO);
			model.addAttribute("commentDatas", commentDatas);
			System.out.println("체크 1"+commentDatas);
		}else {
			model.addAttribute("questionData", qDTO);
			model.addAttribute("commentDatas", commentDatas);
			System.out.println("체크 2"+commentDatas);
		}
		model.addAttribute("advertisementData",adData); // 광고 데이터
		return "user/questionDetail";
	}
}



