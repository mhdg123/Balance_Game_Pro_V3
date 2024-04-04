package com.jarvis.BalanceGame.controller.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.controller.user.async.NameChangeCouponAsync;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.MemberItemDTO;
import com.jarvis.BalanceGame.service.MemberItemService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class ItemUseController {

	
	@Autowired
	MemberItemService memberItemService;
	
	@GetMapping("/itemUseController")
	public String itemUseController(MemberItemDTO miDTO, MemberDTO mDTO, Model model, HttpSession session) {
		if(miDTO.getItemId()==2) {
			//닉변권 사용 컨트롤러로 이동
			return "/user/myInfo";
		}
		
		
		return "/user/index";
		
	}
	
	
}
