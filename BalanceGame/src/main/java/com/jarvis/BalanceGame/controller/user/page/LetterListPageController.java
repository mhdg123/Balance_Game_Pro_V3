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
	public String letterListPageController(LetterDTO lDTO, PageInfoDTO pDTO, Model model, HttpSession session, Gson gson) {
		// 페이징 처리 해야한다
		// 뷰에서 데이터를 받는다 몇페이지 클릭하는지 데이터 받음
		// 그걸 모델에 보내준다
		String loginId = (String)session.getAttribute("loginId");
		if(pDTO.getCurrentPage() == 0) {
			//처음 진입 시 어떤 페이지인지 모르기 때문에
			//현재 페이지를 1로 설정
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<");
			pDTO.setCurrentPage(1);
		}
		
		//해당 유저의 우편을 가져오기위해 설정
		pDTO.setLoginId(loginId);
		//10개씩 우편을 가져오기 위해 10으로 설정
		pDTO.setPasingnationSize(10);
		
		//몇번째의 데이터를 가져올지 설정
		//ex) 1페이지면 0~9 - offset 0
		// 2페이지면 10~19 - offset 10
		pDTO.setOffset(pageInfoService.calculateOffset(pDTO));
		System.out.println(pDTO.getOffset());
		//서치 컨디션으로 어떤 데이터를 가져올 것인지 설정
		pDTO.setSearchCondition("viewAllMessage");
		System.out.println("pDTO" + pDTO);
		//10개 씩 끊어서 데이터를 가져옴
		List<PageInfoDTO> datas = pageInfoService.selectAll(pDTO);
		
		
		//총패이지 수를 가져오기 위해 메세지 총 개수 를 가져옴
		lDTO.setLoginId(loginId);
		lDTO.setSearchCondition("messageCntMemberOne");
		System.out.println(lDTO+"<<<<<<<<<<<<<<<<<<<<<호이");
		lDTO = letterService.selectOne(lDTO);
		System.out.println(lDTO+"<<<<<<<<<<<<<<<<,여기");
		//가져온 우편 개수
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
		
		return "/user/letterList";

	}
}
