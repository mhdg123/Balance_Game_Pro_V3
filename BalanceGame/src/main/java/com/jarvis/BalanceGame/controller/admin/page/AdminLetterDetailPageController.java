package com.jarvis.BalanceGame.controller.admin.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.service.LetterService;

@Controller
@RequestMapping("/admin")
public class AdminLetterDetailPageController {

	@Autowired
	private LetterService letterService;

	@GetMapping("/letterDetailPage")
	public String adminSuggestionDetailPageController(LetterDTO lDTO, Model model) {
		System.out.println("편지 PK id값 : " + lDTO.getLetterId());
		
		lDTO.setSearchCondition("updateAllRead");
		letterService.update(lDTO); // 건의사항 상세페이지 확인시 읽음처리하기
		lDTO.setSearchCondition("viewOneMessage");
		lDTO = letterService.selectOne(lDTO);
		System.out.println("편지 데이터 : " + lDTO);
		if (lDTO == null) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "해당 데이터가 없습니다");
			model.addAttribute("redirect", "/admin/adminPage");
			return "alert";
		}

		model.addAttribute("letterDatas", lDTO);

		return "admin/adminLetterDetail";
	}
}
