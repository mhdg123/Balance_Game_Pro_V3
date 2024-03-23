package com.jarvis.BalanceGame.controller.admin.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.ItemDTO;
import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.service.ItemService;
import com.jarvis.BalanceGame.service.LetterService;

@Controller
@RequestMapping("/admin")
public class AdminItemDetailPageController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/itemDetailPage")
	public String adminItemDetailPageController(ItemDTO lDTO, Model model) {

		lDTO = itemService.selectOne(lDTO);
		System.out.println("관리자 아이템 데이터 : " + lDTO);
		if (lDTO == null) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "해당 데이터가 없습니다");
			model.addAttribute("redirect", "/admin/adminPage");
			return "alert";
		}

		model.addAttribute("itemData", lDTO);

		return "admin/adminItemDetail";
	}
}
