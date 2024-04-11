package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.ItemDTO;
import com.jarvis.BalanceGame.service.ItemService;

@Controller
@RequestMapping("/admin")
public class AdminItemDeleteController {

	@Autowired
	private ItemService itemService;
	
	// 아이템 삭제 요청 기능
	@PostMapping("/adminItemDelete")
	public String adminItemDeleteController(ItemDTO iDTO, Model model) {
		System.out.println("관리자 아이템 삭제 파라미터 : " + iDTO);
		// 아이템 삭제 실행
		boolean flag = 	itemService.delete(iDTO);

		// 실패 처리
		if (!flag) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "아이템삭제 실패했습니다");
			model.addAttribute("redirect", "/admin/adminPage");
			return "alert";
		}
		// 성공 처리
		model.addAttribute("status", "success");
		model.addAttribute("msg", "아이템삭제 성공했습니다");
		model.addAttribute("redirect", "/admin/adminItemManagementPage");

		return "alert";
	}
}
