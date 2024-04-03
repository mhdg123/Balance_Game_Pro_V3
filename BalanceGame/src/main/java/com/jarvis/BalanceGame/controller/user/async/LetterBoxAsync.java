package com.jarvis.BalanceGame.controller.user.async;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.model.dto.PageInfoDTO;
import com.jarvis.BalanceGame.service.LetterService;
import com.jarvis.BalanceGame.service.PageInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LetterBoxAsync {

	@Autowired
	private LetterService letterService;

	@Autowired
	private PageInfoService pageInfoService;

	@PostMapping("/mailBoxAsync")
	public @ResponseBody String mailBoxAsync(LetterDTO lDTO, PageInfoDTO pDTO, Model model, Gson gson,
			HttpSession session) {

		String loginId = (String) session.getAttribute("loginId");
		lDTO.setLoginId(loginId);
		lDTO.setSearchCondition("unreadMemberMessage");
		List<LetterDTO> datas = letterService.selectAll(lDTO);



//		if (datas != null) {
//
//
//		} else {
//			model.addAttribute("status", "fail");
//			model.addAttribute("msg", "등록된 문제가 없습니다.");
//			model.addAttribute("redirect", "");
//			return "alert";
//		}

		return gson.toJson(datas);
	}

	@PostMapping("/mailCheck")
	public @ResponseBody String mailCheck(LetterDTO lDTO, Model model, Gson gson, HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		lDTO.setLoginId(loginId);
		lDTO.setSearchCondition("updateReadStatus");
		letterService.update(lDTO);
		lDTO.setSearchCondition("viewOneMessage");
		return gson.toJson(letterService.selectOne(lDTO));
	}

	@PostMapping("/mailCount")
	public @ResponseBody String mailCount(LetterDTO lDTO, PageInfoDTO pDTO, Model model, Gson gson,
			HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		lDTO.setLoginId(loginId);

		lDTO.setSearchCondition("unreadMemberMessage");
		// 읽지 않은 편지 수를 조회하여 반환
		List<LetterDTO> unreadLetters = letterService.selectAll(lDTO);
		int unreadCount = unreadLetters.size();
		System.out.println("편지 개수"+unreadCount);
		return Integer.toString(unreadCount);
	}

}
