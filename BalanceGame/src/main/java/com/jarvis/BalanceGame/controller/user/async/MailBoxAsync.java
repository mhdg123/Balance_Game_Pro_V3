package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.service.LetterService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class MailBoxAsync {

	@Autowired
	private LetterService letterService;

	@PostMapping("/mailBoxAsync")
	public @ResponseBody String mailBoxAsync(LetterDTO lDTO, Model model, Gson gson, HttpSession session) {
		
		String loginId = (String)session.getAttribute("loginId");
		lDTO.setLoginId(loginId);
		lDTO.setSearchCondition("unReadMessage");

		
		return gson.toJson(letterService.selectAll(lDTO));
	}

	@PostMapping("/mailCheck")
	public @ResponseBody String mailCheck(LetterDTO lDTO, Model model, Gson gson, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		lDTO.setLoginId(loginId);
		letterService.update(lDTO);

		return gson.toJson(letterService.selectOne(lDTO));
	}
}
