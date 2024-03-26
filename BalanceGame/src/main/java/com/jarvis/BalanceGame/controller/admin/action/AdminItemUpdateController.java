package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.jarvis.BalanceGame.model.dto.ItemDTO;
import com.jarvis.BalanceGame.service.ItemService;

import retrofit2.http.POST;

@Controller
@RequestMapping("/admin")
public class AdminItemUpdateController {

	@Autowired
	private ItemService itemService;
	
	@PostMapping("adminItemUpdate")
	public String adminItemUpdateController(ItemDTO iDTO, Model model) {
		System.out.println("관리자 아이템 수정 파라미터 데이터 : " + iDTO);
		boolean flag = 	itemService.update(iDTO);

		if (!flag) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "정보수정 실패했습니다");
			model.addAttribute("redirect", "/admin/adminPage");
			return "alert";
		}
		model.addAttribute("status", "success");
		model.addAttribute("msg", "정보수정 성공했습니다");
		model.addAttribute("redirect", "/admin/adminItemManagementPage");
		
		return "alert";
	}
}
