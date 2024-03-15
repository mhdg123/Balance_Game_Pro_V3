package com.jarvis.BalanceGame.controller.user.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.WishDTO;
import com.jarvis.BalanceGame.service.WishService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class WishListPageController {

	@Autowired
	private WishService WishService;
	
	@GetMapping("/wishListPage")
	public String wishListPageController(WishDTO wDTO, Model model, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		wDTO.setLoginId(loginId);
		
		List<WishDTO> datas = WishService.selectAll(wDTO);
		
		wDTO = WishService.selectOne(wDTO);
		
		System.out.println("SLECTALL datas: " + datas);
		System.out.println("wDTO" + wDTO);
		
		if(datas == null) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "해당 데이터가 없습니다");
			model.addAttribute("redirect", "");
			return "alert";
		}
		
		model.addAttribute("sdatas", datas);
		return "user/wishList";
	}
}