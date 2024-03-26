package com.jarvis.BalanceGame.controller.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;
import retrofit2.http.POST;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/login")
	public String loginController(MemberDTO mDTO, Model model,HttpSession session) {
		System.out.println("로그인 기능 실행");
		mDTO.setSearchCondition("login");
		mDTO = memberService.selectOne(mDTO);
		if (mDTO != null) {
			if ("ADMIN".equals(mDTO.getRole())) {
				session.setAttribute("loginId", mDTO.getLoginId());
				model.addAttribute("status", "success");
				model.addAttribute("msg", mDTO.getLoginId() + " 관리자님 로그인 하셨습니다.");
				model.addAttribute("redirect", "/admin/adminPage");
				return "alert";
				
			} else {
				// 로그인 성공
				session.setAttribute("loginId", mDTO.getLoginId());
				String loginId = (String)session.getAttribute("loginId");
				mDTO.setLoginId(loginId);
				model.addAttribute("status", "success");
				model.addAttribute("msg", mDTO.getLoginId() + "님 로그인 하셨습니다.");
				model.addAttribute("redirect", "/");
				
				mDTO.setSearchCondition("viewCoin");
				mDTO = memberService.selectOne(mDTO);
				
				session.setAttribute("coin", mDTO.getCoin());
				
				return "alert";
			}
		}
			// 로그인 실패
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "로그인 정보가 틀렸습니다 다시 확인해주세요");
			model.addAttribute("redirect", "/user/loginPage");
			return "alert";

	}
	
}