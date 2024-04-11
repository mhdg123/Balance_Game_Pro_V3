package com.jarvis.BalanceGame.controller.admin.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.ItemDTO;
import com.jarvis.BalanceGame.service.ItemService;

@Controller
@RequestMapping("/admin")
public class AdminItemDetailPageController {

	@Autowired
	private ItemService itemService;

	// 아이템 상세 페이지로 이동
	@GetMapping("/itemDetailPage")
	public String adminItemDetailPageController(ItemDTO iDTO, Model model) {
		System.out.println("관리자 아이템 상세페이지 파라미터 데이터 :  " + iDTO);
		iDTO.setSearchCondition("itemViewOne");
		System.out.println("관리자 아이템 상세 페이지 이미지 상대 경로 : " + iDTO.getItemImg());
		iDTO = itemService.selectOne(iDTO);
		System.out.println("관리자 아이템 데이터 : " + iDTO);
		if (iDTO == null) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "해당 데이터가 없습니다");
			model.addAttribute("redirect", "/admin/adminItemManagementPage");
			return "alert";
		}
		model.addAttribute("itemData", iDTO);

		return "admin/adminItemDetail";
	}
}
