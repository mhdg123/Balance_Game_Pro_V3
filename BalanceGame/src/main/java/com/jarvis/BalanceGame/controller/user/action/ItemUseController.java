package com.jarvis.BalanceGame.controller.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.ItemLogDTO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.MemberItemDTO;
import com.jarvis.BalanceGame.service.ItemLogService;
import com.jarvis.BalanceGame.service.MemberItemService;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class ItemUseController {

	
	@Autowired
	private MemberItemService memberItemService;
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/itemUseController")
	public String itemUseController(MemberItemDTO miDTO, MemberDTO mDTO, Model model, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		String commentStatus = (String)session.getAttribute("commentStatus");
		mDTO.setWriteStatus(commentStatus);
		mDTO.setLoginId(loginId);
		miDTO.setLoginId(loginId);
		if(miDTO.getItemId()==1) {
			//닉변권 사용 컨트롤러로 이동
			return "redirect:/user/myPageUpdatePageController";
		}
		if(miDTO.getItemId()==3) {
			if(mDTO.getWriteStatus().equals("T")) {
				model.addAttribute("status", "fail");
				model.addAttribute("msg", "댓글 사용이 가능합니다");
				model.addAttribute("redirect", "/user/myInfoPage");
				System.out.println("검사하고 여기들어온거야");
				return "alert";
			}
			mDTO.setSearchCondition("updateCommentStatusT");
			memberService.update(mDTO);
			
			session.setAttribute("commentStatus", "T");
			miDTO.setSearchCondition("useItem");
			memberItemService.update(miDTO);
			System.out.println(miDTO);
			System.out.println("0000000-------------------");
			return "redirect:/user/myInfoPage";
		}
		
		
		return "/user/index";
		
	}
	
	
}
