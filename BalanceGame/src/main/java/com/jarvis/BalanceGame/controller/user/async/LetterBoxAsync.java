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
		pDTO.setLoginId(loginId);
		pDTO.setPasingnationSize(10);
		pageInfoService.calculateOffset(pDTO);
		pDTO.setSearchCondition("unReadMessageMember");
		List<PageInfoDTO> datas = pageInfoService.selectAll(pDTO);

		lDTO.setSearchCondition("messageCntMember");
		lDTO = letterService.selectOne(lDTO);
		System.out.println(lDTO);
		pDTO.setTotalRows(lDTO.getCnt());
		int totalPage = pageInfoService.calcTotalPages(pDTO); // 총페이지 수

		System.out.println(totalPage);

		if (datas != null) {
			model.addAttribute("letterDatas", datas);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("page", pDTO.getCurrentPage());
		} else {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "등록된 문제가 없습니다.");
			model.addAttribute("redirect", "");
			return "alert";
		}

		return gson.toJson(datas);
	}

	@PostMapping("/mailCheck")
	public @ResponseBody String mailCheck(LetterDTO lDTO, Model model, Gson gson, HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		lDTO.setLoginId(loginId);
		lDTO.setSearchCondition("updateReadStatus");
		letterService.update(lDTO);

		return gson.toJson(letterService.selectOne(lDTO));
	}

	@PostMapping("/mailCount")
	public @ResponseBody String mailCount(LetterDTO lDTO, PageInfoDTO pDTO, Model model, Gson gson,
			HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		pDTO.setLoginId(loginId);

		pDTO.setSearchCondition("unReadMessageMember");
		// 읽지 않은 편지 수를 조회하여 반환
		List<PageInfoDTO> unreadLetters = pageInfoService.selectAll(pDTO);
		int unreadCount = unreadLetters.size();

		return Integer.toString(unreadCount);
	}

}
