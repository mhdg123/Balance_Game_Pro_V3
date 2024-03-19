package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;

@Controller
@RequestMapping("/user")
public class JoinPageController {
   
	@GetMapping("/joinPage")
   public String joinPageController(Model model) {
      System.out.println("회원가입 페이지 이동");
      model.addAttribute("status", "balanceJoin");
      // 기본 회원가입 페이지 폼 분기 처리
      return "user/join";
   }
	
	
	@PostMapping("/join/kakao")
	public String kakaoJoin(MemberDTO mDTO, Model model) {
		System.out.println(mDTO + "카카오로 처음 로그인 해서 회원가입 처리 ");
		// 비회원일때
		model.addAttribute("mDTO", mDTO);
		model.addAttribute("status", "socialJoin");
		return "user/join";
		
		// 데이터 insert는 회원가입페이지에서 처리할 예정
		
	}
}
