package com.jarvis.BalanceGame.controller.admin.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.jarvis.BalanceGame.model.dto.ItemDTO;
import com.jarvis.BalanceGame.service.ItemService;

@Controller
@RequestMapping("/admin")
public class AdminItemManagementPageController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/adminItemManagementPage")
	public String adminCreateTitlePageController(ItemDTO iDTO, Model model) {
		System.out.println("관리자 아이템 관리 페이지 이동");

		List<ItemDTO> datas = itemService.selectAll(iDTO);
		/*
		 * if (itemDatas.size() >= 0) { model.addAttribute("status", "fail");
		 * model.addAttribute("msg", "등록된 아이템이 없습니다."); model.addAttribute("redirect",
		 * "/admin/adminPage");
		 * 
		 * return "alert"; }
		 */
		System.out.println("관리자 등록된 아이템 데이터 : " + datas);
		model.addAttribute("itemDatas", datas);
		return "admin/adminItemManagement";
	}

}
