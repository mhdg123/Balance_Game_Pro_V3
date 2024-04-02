package com.jarvis.BalanceGame.controller.user.page;

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
import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.LetterService;
import com.jarvis.BalanceGame.service.PageInfoService;

import jakarta.servlet.http.HttpSession;
import kotlinx.serialization.json.Json;

@Controller
@RequestMapping("/user")
public class LetterListPageController {

	@Autowired
	private LetterService letterService;
	
	@Autowired
	private PageInfoService pageInfoService;
	
	
	@GetMapping("/letterListPage")
	public @ResponseBody String letterListPageController(LetterDTO lDTO, PageInfoDTO pDTO, Model model, HttpSession session, Gson gson) {
		// 페이징 처리 해야한다
		// 뷰에서 데이터를 받는다 몇페이지 클릭하는지 데이터 받음
		// 그걸 모델에 보내준다
		
		if(Integer.valueOf(pDTO.getCurrentPage()) == null) {
			pDTO.setCurrentPage(1);
		}
		
		pDTO.setPasingnationSize(10);
		pageInfoService.calculateOffset(pDTO);
		pDTO.setSearchCondition("viewAllMessage");
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
