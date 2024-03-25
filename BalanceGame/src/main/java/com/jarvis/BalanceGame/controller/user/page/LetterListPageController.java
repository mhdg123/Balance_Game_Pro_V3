package com.jarvis.BalanceGame.controller.user.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.service.LetterService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LetterListPageController {

	@Autowired
	private LetterService letterService;
	
	@GetMapping("/letterListPage")
	public String letterListPageController(LetterDTO lDTO,Model model, HttpSession session) {
		
		String loginId = (String)session.getAttribute("loginId");
		
		lDTO.setLoginId(loginId);
		
		lDTO.setSearchCondition("viewAllMessage");
		
		List<LetterDTO> ldata = letterService.selectAll(lDTO);
		
		model.addAttribute("listDatas", ldata);
		
		return "user/letterList";
		
	}
}
