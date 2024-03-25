package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.service.LetterService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LetterListAsync {
	
	@Autowired
	private LetterService letterService;
	
	@GetMapping("/mailListAsync")
	public @ResponseBody String mailListAsync(LetterDTO lDTO, HttpSession session) {
		
		String loginId = (String)session.getAttribute("loginId");
		lDTO.setLoginId(loginId);
		
		lDTO.setLoginId(loginId);
		System.out.println("쪽지읽음 확인 1"+lDTO);
		
		boolean flag = false;
		String src="";
		
		if (letterService.update(lDTO)) {
			flag = letterService.insert(lDTO);
			if (flag) {
				src="readOn";
				System.out.println("쪽지읽음 확인2"+ lDTO);
			}
		}else {
			flag= letterService.update(lDTO);
			if (flag) {
				src="readOff";
				System.out.println("쪽지읽음 확인3"+ lDTO);
			}
		}
		
		if(!flag) {
			
			System.out.println("실패");
			return "실패";
		}
			System.out.println(src);

		return src;
	}
	
}