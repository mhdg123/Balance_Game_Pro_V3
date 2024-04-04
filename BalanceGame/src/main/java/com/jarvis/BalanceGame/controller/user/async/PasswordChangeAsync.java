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
public class PasswordChangeAsync {

	@Autowired
	private MemberService memberService;
	

	@PostMapping("/passwordChangeAsync")
	public @ResponseBody String resignAsync(MemberDTO mDTO) {
		System.out.println("파라미터 비밀번호 값" + mDTO );
		mDTO.setSearchCondition("updateTempPw");
		boolean flag = memberService.update(mDTO);
		if (!flag) {
			System.out.println("비밀번호 변경 실패");
			return "fail";
		}
		System.out.println("비밀번호 변경완료");
		return "success";

	}
}
