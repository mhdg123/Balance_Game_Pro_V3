package com.jarvis.BalanceGame.controller.user.async;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jarvis.BalanceGame.model.dto.CommentDTO;
import com.jarvis.BalanceGame.model.dto.PageInfoDTO;
import com.jarvis.BalanceGame.service.CommentService;
import com.jarvis.BalanceGame.service.PageInfoService;

import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("/user")
public class CommentAsync {

	@Autowired
	private CommentService commentService;
	@Autowired
	private PageInfoService pageInfoService;
	
	@PostMapping("/commentAsync")
	public @ResponseBody String commentAsync(CommentDTO cDTO,PageInfoDTO pDTO, Model model, Gson gson, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		pDTO.setLoginId(loginId);
		if(pDTO.getCurrentPage() == 0) {
			pDTO.setCurrentPage(1);
		}
		pDTO.setPasingnationSize(10);
		pDTO.setOffset(pageInfoService.calculateOffset(pDTO));
		pDTO.setSearchCondition("questionComments");
		List<PageInfoDTO> datas=pageInfoService.selectAll(pDTO);
		
		cDTO.setSearchCondition("commentsCntQuestion");
		cDTO = commentService.selectOne(cDTO);
		System.out.println(cDTO);
		pDTO.setTotalRows(cDTO.getCnt());
		int totalPage = pageInfoService.calcTotalPages(pDTO);	// 총페이지 수
		
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
		String json =gson.toJson(datas);
		if (datas.isEmpty()) {
			System.out.println("실패");
		}else {
			System.out.println(json);
		}
		return gson.toJson(datas);

	}
}
