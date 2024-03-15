package com.jarvis.BalanceGame.controller.user.action;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class ResignController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/resignAction")
	public String ResignController(MemberDTO mDTO, Model model, HttpSession session) {
		model.addAttribute("UTF-8");

		String memberLoginId = mDTO.getLoginId();

		if (memberService.delete(mDTO)) {
			model.addAttribute("status", "success");
			model.addAttribute("msg", "밸런스를 이용해주셔서 감사합니다");
			model.addAttribute("redirect", "/");
			session.invalidate();
			return "/alert";

		}
		model.addAttribute("status", "fail");
		model.addAttribute("msg", "회원탈퇴가 취소되었습니다");
		model.addAttribute("redirect", "/");
		
		return "/alert";
	}

}