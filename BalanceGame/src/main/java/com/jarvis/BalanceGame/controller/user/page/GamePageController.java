package com.jarvis.BalanceGame.controller.user.page;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.AdvertisementDTO;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.AdvertisementService;
import com.jarvis.BalanceGame.service.QuestionService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class GamePageController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AdvertisementService advertisementService;
	
	@GetMapping("/gamePage")
	public String gamePageController(QuestionDTO qDTO, Model model, HttpSession session, AdvertisementDTO aDTO) {
		aDTO.setSearchCondition("adRandomChoice");
		AdvertisementDTO adData = advertisementService.selectOne(aDTO);
		System.out.println("게임 페이지 광고 데이터 : " + adData );
		
		List<Integer> list; // 지금까지 풀었던 리스트 
		System.out.println("컨트롤 리스트"+session.getAttribute("qList"));
		
		if (session.getAttribute("qList") == null) {
			list = new ArrayList<Integer>(); // 질문pk만 들고다님 
		} else {
			list = (ArrayList<Integer>) session.getAttribute("qList");
		}
		
		String loginId = (String) session.getAttribute("loginId");
		
		qDTO.setSearchCondition("questionCount");
		qDTO.setQuestionAccess("T");
		System.out.println("게임페이지 로그");
		if(questionService.selectOne(qDTO).getQuestionCount()>list.size()) {
			while (true) {
				int i=0;
				qDTO.setSearchCondition("showRandomQuestion");
				
				// System.out.println(loginId);
				qDTO.setWriter(loginId);
				qDTO = questionService.selectOne(qDTO);
				System.out.println(qDTO);
				for (i=0; i < list.size(); i++) {
					if (list.get(i) == qDTO.getQuestionId()) {
						
						System.out.println("중복 아이디 : "+qDTO.getQuestionId());
						break;
					}
				}
				// System.out.println("GamePageAction : "+qDto.getSave());
				if (list.size() <= i) {
					break;
				}
			}
			list.add(qDTO.getQuestionId()); // 이미 푼 문제 pk를 리스트에 올림 
			session.setAttribute("qList", list); // 새로운 리스트니까 세션에 다시 저장 
			model.addAttribute("questionData", qDTO); // 뷰한테 주는 것 
			model.addAttribute("advertisementData", adData); // 뷰한테 주는 것 
			
			return "user/game";
			}
			else {
				session.removeAttribute("qList");
			}
		
		
		return "user/index";
	}
	
	
}