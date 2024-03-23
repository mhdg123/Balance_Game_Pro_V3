package com.jarvis.BalanceGame.controller.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.ItemDTO;
import com.jarvis.BalanceGame.model.dto.ItemLogDTO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.MemberItemDTO;
import com.jarvis.BalanceGame.service.ItemLogService;
import com.jarvis.BalanceGame.service.ItemService;
import com.jarvis.BalanceGame.service.MemberItemService;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class ItemPurchase {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ItemLogService itemLogService;
	
	@Autowired
	private MemberItemService memberItemService;
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/itemPurchase")
	public String itemPurchase(MemberDTO mDTO, MemberItemDTO miDTO, ItemDTO iDTO, ItemLogDTO ilDTO, Model model, HttpSession session) {
		
		// 여기서 해야하는것
		// 유저 포인트 업데이트
		// 유저 아이템 갯수 추가
		// 아이템 로그 추가
		
		
		String loginId = (String)session.getAttribute("loginId");
		mDTO.setLoginId(loginId);
		miDTO.setLoginId(loginId);
		
		miDTO = memberItemService.selectOne(miDTO);
		if(miDTO == null) {
			memberItemService.insert(miDTO);
			return "user/index";
		}
		memberItemService.update(miDTO);
		
		itemLogService.insert(ilDTO);
		
		
		
		
		return "user/index";
	}
}