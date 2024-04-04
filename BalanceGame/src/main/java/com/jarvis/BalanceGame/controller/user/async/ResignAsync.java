package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.CommentDTO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.CommentService;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("/user")
public class ResignAsync {

	@Autowired
	private MemberService memberService;
	

	@PostMapping("/resignAsync")
	public @ResponseBody String resignAsync(MemberDTO mDTO) {
		System.out.println("파라미터 아이디 값" + mDTO.getLoginId() );
		boolean flag = memberService.delete(mDTO);
		if (!flag) {
			System.out.println("회원 탈퇴 실패");
			return "fail";
		}
		System.out.println("회원 탈퇴 성공");
		return "success";

	}
}
