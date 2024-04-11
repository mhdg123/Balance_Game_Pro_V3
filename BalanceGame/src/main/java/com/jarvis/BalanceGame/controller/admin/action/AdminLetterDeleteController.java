package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.service.LetterService;

@Controller
@RequestMapping("/admin")
public class AdminLetterDeleteController {

	@Autowired
	private LetterService letterService;
	
	// 관리자가 건의사항을 삭제하는 기능
	@PostMapping("/letterDelete")
	public String adminLetterDeleteController(LetterDTO lDTO, Model model) {
		System.out.println("건의내용 삭제 기능 실행");
		System.out.println("건의내용 삭제 시 건의사항PK 데이터 " + lDTO.getLetterId());
		
		// 건의사항 삭제 수행
		boolean flag = letterService.delete(lDTO);
		
		// 실패 처리
		if(!flag) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "실패했습니다");
			model.addAttribute("redirect", "adminPage");
			return "alert";
		}
		// 성공 처리
		model.addAttribute("status", "success");
		model.addAttribute("msg", "삭제했습니다");
		model.addAttribute("redirect", "adminPage");
		return "alert";
	}
}


