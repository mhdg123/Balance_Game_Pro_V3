package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.ItemDTO;
import com.jarvis.BalanceGame.service.ItemService;

@Controller
@RequestMapping("/admin")
public class AdminItemDeleteController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/adminItemDelete")
	public String adminItemDeleteController(ItemDTO iDTO, Model model) {
		
		boolean flag = 	itemService.delete(iDTO);

		if (!flag) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "아이템삭제 실패했습니다");
			model.addAttribute("redirect", "admin/adminPage");
			return "alert";
		}
		model.addAttribute("status", "success");
		model.addAttribute("msg", "아이템삭제 성공했습니다");
		model.addAttribute("redirect", "admin/adminPage");

		return "alert";
	}
}
