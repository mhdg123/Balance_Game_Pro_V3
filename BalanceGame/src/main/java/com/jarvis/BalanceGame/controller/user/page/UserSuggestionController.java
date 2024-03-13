package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserSuggestionController {

	@Autowired
	private SuggestionService suggestionService;
	
	@RequestMapping("/userSuggestionAction")
	public String UserSuggertionController(SuggestionDTO sDTO, Model model, HttpSession session) {
		
		String loginId = (String) session.getAttribute("loginId");
		
		sDTO.setLoginId(loginId); // 건의하는 유저 아이디

		
		System.out.println("건의사항 결과" + flag);
		
		boolean flag = suggestionService.insert(sDTO);
		
		if (!flag) {
			model.addAttribute("msg", "전송에 실패했습니다");
			model.addAttribute("status", "failClose");
			return "alert";
		}
		
		model.addAttribute("status", "close");
		model.addAttribute("msg", "건의사항이 발송되었습니다.");
		return "alert";
	}
}
