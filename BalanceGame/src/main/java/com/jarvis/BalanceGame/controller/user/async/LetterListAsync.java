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
		
		String src="";
		
		letterService.update(lDTO);
		
		if(lDTO.getLetterStatus()=="T") {
			src="readOn";
			System.out.println("쪽지읽음 확인2"+ lDTO);
		}else {
			src="readOff";
			System.out.println("쪽지읽음 확인3"+ lDTO);
		}

			System.out.println(src);

		return src;
	}
	
}