package com.jarvis.BalanceGame.controller.user.page;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.QuestionService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class GamePageController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/gamePage")
	public String gamePageController(QuestionDTO qDTO, Model model, HttpSession session) {
		
		List<Integer> list;
		System.out.println("컨트롤 리스트"+session.getAttribute("qList"));
		
		if (session.getAttribute("qList") == null) {
			list = new ArrayList<Integer>();
		} else {
			list = (ArrayList<Integer>) session.getAttribute("qList");
		}
		
		String loginId = (String) session.getAttribute("loginId");
		
		qDTO.setSearchCondition("총문제수");
		qDTO.setQuestionAccess("T");
		
		if(questionService.selectOne(qDTO).getCnt()>list.size()) {
			while (true) {
				int i=0;
				qDTO.setSearchCondition("질문랜덤생성");
				
				// System.out.println(loginId);
				qDTO.setLoginId(loginId);
				qDTO = questionService.selectOne(qDTO);
				for (i=0; i < list.size(); i++) {
					if (list.get(i) == qDTO.getqId()) {
						
						System.out.println("중복 아이디 : "+qDTO.getqId());
						break;
					}
				}
				// System.out.println("GamePageAction : "+qDto.getSave());
				if (list.size() <= i) {
					break;
				}
			}
			list.add(qDTO.getqId());
			session.setAttribute("qList", list);
			model.addAttribute("data", qDTO);
			return "game";
			}
			else {
				session.removeAttribute("qList");
			}
		
		
		return "redirect:main";
	}
	
	
}