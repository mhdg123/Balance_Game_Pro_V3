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
public class AdminCreateItemPageController {
	
	@Autowired
	private ItemService itemService;

	// 아이템 생성 페이지로 이동
	@GetMapping("/adminCreateItemPage")
	public String adminCreateTitlePageController(ItemDTO iDTO, Model model) {
		System.out.println("관리자 아이템 생성 페이지 이동");
		//  (아이템  마지막 PK값 데이터 searchCondition 사용해서 가져오기 dao추가됨)
		iDTO.setSearchCondition("itemNextId");
		ItemDTO itemLastPk =  itemService.selectOne(iDTO);
		System.out.println("관리자 아이템 추가페이지 이동시 마지막 PK : " + itemLastPk.getItemNextId());
		model.addAttribute("itemLastPk", itemLastPk.getItemNextId());
		return "admin/adminCreateItem";
	}
	
}
