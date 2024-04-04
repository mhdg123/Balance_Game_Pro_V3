package com.jarvis.BalanceGame.controller.user.async;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
public class LetterListPrintAsync {

	@Autowired
	private LetterService letterService;
	
	@Autowired
	private PageInfoService pageInfoService;
	
	@GetMapping("/letterListPrint")
	public @ResponseBody String letterListPrint(LetterDTO lDTO, PageInfoDTO pDTO, Model model, HttpSession session, Gson gson) {
		
		String loginId = (String)session.getAttribute("loginId");
		if(pDTO.getCurrentPage() == 0) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<");
			pDTO.setCurrentPage(1);
		}
		pDTO.setLoginId(loginId);
		pDTO.setPasingnationSize(10);
		
		pDTO.setOffset(pageInfoService.calculateOffset(pDTO));
		System.out.println(pDTO.getOffset());
		pDTO.setSearchCondition("viewAllMessage");
		System.out.println("pDTO" + pDTO);
		List<PageInfoDTO> datas = pageInfoService.selectAll(pDTO);
		
		lDTO.setSearchCondition("messageCntMember");
		lDTO = letterService.selectOne(lDTO);
		System.out.println(lDTO);
		pDTO.setTotalRows(lDTO.getCnt());
		int totalPage = pageInfoService.calcTotalPages(pDTO);	// 총페이지 수
		
		System.out.println(totalPage);
		
		if(datas != null) {
			model.addAttribute("letterDatas", datas);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("page", pDTO.getCurrentPage());
		}else {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "등록된 문제가 없습니다.");
			model.addAttribute("redirect", "");
			return "alert";
		}
		
		return gson.toJson(datas);

	}
}