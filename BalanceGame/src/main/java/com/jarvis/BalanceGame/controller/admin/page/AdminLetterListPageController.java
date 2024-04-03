package com.jarvis.BalanceGame.controller.admin.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.model.dto.PageInfoDTO;
import com.jarvis.BalanceGame.service.LetterService;
import com.jarvis.BalanceGame.service.PageInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminLetterListPageController {

	@Autowired
	private LetterService letterService;
	
	@Autowired
	private PageInfoService pageInfoService;
	
	@GetMapping("/adminLetterListPage")
	public String adminLetterListPageController(LetterDTO lDTO,PageInfoDTO pDTO, Model model,HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		
		if(Integer.valueOf(pDTO.getCurrentPage()) == null) {
			pDTO.setCurrentPage(1);
		}
		pDTO.setLoginId(loginId);
		pDTO.setPasingnationSize(10);
		pageInfoService.calculateOffset(pDTO);
		pDTO.setSearchCondition("viewAllSuggestionMessageAdmin");
		List<PageInfoDTO> datas = pageInfoService.selectAll(pDTO);
		
		lDTO.setSearchCondition("questionCount");
		lDTO = letterService.selectOne(lDTO);
		System.out.println(lDTO);
		pDTO.setTotalRows(qDTO.getQuestionCount());
		int totalPage = pageInfoService.calcTotalPages(pDTO);	// 총페이지 수
		
		
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
		
		
		model.addAttribute("letterDatas", lDatas);
		
		return "admin/adminLetterListPage";
	}
}
