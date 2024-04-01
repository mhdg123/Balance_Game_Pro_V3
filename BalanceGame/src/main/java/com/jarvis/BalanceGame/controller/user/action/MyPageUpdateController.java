package com.jarvis.BalanceGame.controller.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.MemberItemDTO;
import com.jarvis.BalanceGame.service.MemberItemService;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class MyPageUpdateController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberItemService memberItemService;
	
	@PostMapping("/myInfoChangePage")
	public String MyPageUpdateController(MemberDTO mDTO, MemberItemDTO miDTO, Model model, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		mDTO.setLoginId(loginId);
		mDTO.setSearchCondition("viewOne");

		String oldName = memberService.selectOne(mDTO).getNickName();

		mDTO.setSearchCondition("midifyMyInfo");
		if (!memberService.update(mDTO)) {
			System.out.println("내정보 변경 실패");
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "정보 변경에 실패하였습니다.");
			model.addAttribute("redirect", "/user/myInfoPage");
			return "alert";

		}

		System.out.println("내정보 변경 성공");
		model.addAttribute("status", "success");
		model.addAttribute("msg", "정보변경 성공");
		model.addAttribute("redirect", "/user/myInfoPage");

		if (oldName != mDTO.getNickName()) {

			miDTO.setSearchCondition("useItem");
			memberItemService.update(miDTO);
			
		return "alert";
		}
		return "alert";
	}

}