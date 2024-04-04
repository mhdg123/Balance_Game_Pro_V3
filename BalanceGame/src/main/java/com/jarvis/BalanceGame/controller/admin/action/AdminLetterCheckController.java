package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.service.LetterService;

import jakarta.servlet.http.HttpSession;
import retrofit2.http.POST;

@Controller
@RequestMapping("/admin")
public class AdminLetterCheckController {

	@Autowired
	private LetterService letterService;
	
	@PostMapping("/adminLetterCheck")
	public String adminLetterCheckController(LetterDTO lDTO, Model model, HttpSession session) {
		System.out.println("관리자페이지에서" +lDTO.getLetterId()+ " 번째 건의사항을 읽음");
		System.out.println("여기 들어온다1");
		lDTO.setSearchCondition("updateReadStatus");
		boolean flag = letterService.update(lDTO);
		System.out.println(lDTO.getLetterId());
		System.out.println(flag);
		if(!flag) {
			model.addAttribute("status" ,"fail");
			model.addAttribute("msg" ,"오류가 발생했습니다. 관리자에게 문의해주세요");
			model.addAttribute("redirect" ,"/admin/adminPage");
			System.out.println("여기 들어온다12");
			return "alert";
		}
		
		System.out.println("여기 들어온다13");
		System.out.println("관리자가 건의사항 읽음 처리 완료");
		model.addAttribute("status" ,"success");
		model.addAttribute("msg" ,"건의사항을 확인했습니다.");
		model.addAttribute("redirect" ,"/admin/adminPage");
		return  "alert";
	}
}
