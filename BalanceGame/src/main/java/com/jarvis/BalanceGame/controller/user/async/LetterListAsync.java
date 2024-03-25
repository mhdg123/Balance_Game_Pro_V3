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
		
		
		
		
		
		
		
		
		return "";
	}
	
}

wDTO.setLoginId((String)session.getAttribute("loginId"));
System.out.println("찜하기 확인1"+ wDTO);

boolean flag=false; 
String src="";
if (wishService.selectOne(wDTO) == null) {
	flag = wishService.insert(wDTO);
	if (flag) {
		src="wishOn";
		System.out.println("찜하기 확인2"+ wDTO);
	}
}else {
	flag= wishService.delete(wDTO);
	if (flag) {
		src="wishOff";
		System.out.println("찜하기 확인3"+ wDTO);
	}
}

if(!flag) {
	
	System.out.println("실패");
	return "실패";
}
	System.out.println(src);

return src;
