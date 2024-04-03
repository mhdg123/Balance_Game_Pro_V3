package com.jarvis.BalanceGame.controller.admin.page;

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
@RequestMapping("/admin")
public class AdminQuestionAccessPageController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private PageInfoService pageInfoService;
	
	@GetMapping("/questionAccessPage")
	public String adminTitleAccessPageController(QuestionDTO qDTO, PageInfoDTO pDTO, Model model, HttpSession session) {
		
		String loginId = (String)session.getAttribute("loginId");
		if(pDTO.getCurrentPage() == 0) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<");
			pDTO.setCurrentPage(1);
		}
		
		pDTO.setLoginId(loginId);
		pDTO.setPasingnationSize(10);
		
		pDTO.setOffset(pageInfoService.calculateOffset(pDTO));
		System.out.println(pDTO.getOffset());
		pDTO.setSearchCondition("adminViewAllOfUnapprovedQuestions");
		System.out.println("pDTO" + pDTO);
		List<PageInfoDTO> datas = pageInfoService.selectAll(pDTO);
		
		qDTO.setQuestionAccess("F");
		qDTO.setSearchCondition("questionCount");
		qDTO = questionService.selectOne(qDTO);
		System.out.println(qDTO);
		pDTO.setTotalRows(qDTO.getQuestionCount());
		int totalPage = pageInfoService.calcTotalPages(pDTO);	// 총페이지 수
		

		System.out.println(totalPage);
		
		if(datas != null) {
			model.addAttribute("questionDatas_f", datas);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("page", pDTO.getCurrentPage());
		}else {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "등록된 문제가 없습니다.");
			model.addAttribute("redirect", "");
			return "alert";
		}


		return "admin/adminQuestionAccess";
	}
}

