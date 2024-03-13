package com.jarvis.BalanceGame.controller.user.page;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class WishListPageController {

	@Autowired
	private SaveService saveService;
	
	@RequestMapping("/wishListPage")
	public String WishListPageController(SaveDTO sDTO, Model model, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		sDTO.setLoginId(loginId);
		
		ArrayList<SaveDTO> datas = saveService.selectAll(sDTO);
		
		sDTO = saveService.selectOne(sDTO);
		
		System.out.println("SLECTALL datas: " + datas);
		System.out.println("sDTO" + sDTO);
		
		if(datas == null) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "해당 데이터가 없습니다");
			model.addAttribute("redirect", "main.do");
			return "alert";
		}
		
		model.addAttribute("sdatas", datas);
		return "wishList";
	}
}