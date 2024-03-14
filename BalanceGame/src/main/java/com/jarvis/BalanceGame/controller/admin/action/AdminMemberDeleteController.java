package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;
//한글코딩
// 뷰에서 보내준 회원 아이디를 셋팅해서
// 모델의 멤버DAO delete로 보냄

@Controller
@RequestMapping("/admin")
public class AdminMemberDeleteController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/adminMemberDelete")
	public String adminMemberDeleteController(MemberDTO mDTO, Model model, HttpSession session) {
		mDTO.setLoginId((String)session.getAttribute("loginId"));
		mDTO.setSearchCondition("회원삭제");
		
		boolean flag = memberService.delete(mDTO);
		
		if (!flag) {
		      System.out.println("삭제 실패");
		      model.addAttribute("status", "fail");
		      model.addAttribute("msg", "잘못된 요청입니다.");
		      model.addAttribute("redirect", "adminMemberManagementPage");
		      return "alert";
		   }
		   System.out.println("삭제 성공");
		   model.addAttribute("status", "success");
		   model.addAttribute("msg", "삭제되었습니다");
		   model.addAttribute("redirect", "adminMemberManagementPage");
		return "alert";
	}
}
