package com.jarvis.BalanceGame.controller.admin.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		iDTO.setSearchCondition("itemType");
		List<ItemDTO> itemType = itemService.selectAll(iDTO);
		iDTO.setSearchCondition("pointType");
		List<ItemDTO> pointType = itemService.selectAll(iDTO);

		model.addAttribute("itemTypeDatas", itemType);
		model.addAttribute("pointTypeDatas", pointType);
		System.out.println("관리자 등록된 아이템 데이터 : " + itemType);
		System.out.println("관리자 등록된 포인트 데이터 : " + pointType);
		model.addAttribute("itemDatas", itemType);
		model.addAttribute("pointType", pointType);
		return "admin/adminItemManagement";
	}

}
