package com.jarvis.BalanceGame.controller.user.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.PageInfoDTO;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.PageInfoService;
import com.jarvis.BalanceGame.service.QuestionService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class QuestionListPageController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private PageInfoService pageInfoService;
	
	@GetMapping("/questionListPage")
	public String titleLisgtPageControllter(QuestionDTO qDTO,PageInfoDTO pDTO, Model model, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		if(pDTO.getCurrentPage() == 0) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<");
			pDTO.setCurrentPage(1);
		}
		pDTO.setLoginId(loginId);
		pDTO.setPasingnationSize(10);
		pDTO.setOffset(pageInfoService.calculateOffset(pDTO));
		pDTO.setSearchCondition("viewAllOfQuestionList");
		System.out.println("pDTO 로그 : "+pDTO);
		List<PageInfoDTO> datas = pageInfoService.selectAll(pDTO);
		
		
		
		qDTO.setSearchCondition("questionCount");
		qDTO.setQuestionAccess("T");
		qDTO = questionService.selectOne(qDTO);
		System.out.println(qDTO);
		pDTO.setTotalRows(qDTO.getQuestionCount());
		int totalPage = pageInfoService.calcTotalPages(pDTO);	// 총페이지 수
		
		
		
//		qDTO.setSearchCondition("viewAllOfQuestionList");
//		qDTO.setWriter((String)session.getAttribute("loginId"));
//		List<QuestionDTO> datas = questionService.selectAll(qDTO);
		System.out.println(totalPage);
		
		if(datas != null) {
			model.addAttribute("questionDatas", datas);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("page", pDTO.getCurrentPage());
		}else {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "등록된 문제가 없습니다.");
			model.addAttribute("redirect", "");
			return "alert";
		}
		
		return "user/questionList";
	}
}