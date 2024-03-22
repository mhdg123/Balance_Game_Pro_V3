package com.jarvis.BalanceGame.controller.user.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.ItemDTO;

@Controller
@RequestMapping("/admin")
public class ItemCreateController {

	/*
	 * @Autowired private ItemService itemService;
	 */
	
	
	@PostMapping("/itemCreate")
	public String itemCreate(ItemDTO iDTO) {
		System.out.println("관리자 아이템 생성 기능");
		System.out.println("아이템 생성 파라미터 데이터 : " + iDTO);
		
//		boolean itemCreateStatus = itemService.insert(iDTO);
//		
//		if(itemCreateStatus) {
//			System.out.println("아이템 생성 성공");
//			model.addAttribute("status" , "success");
//			model.addAttribute("msg" , iDTO.getItemName() + "을 추가 했습니다.");
//			model.addAttribute("redirect" , "/admin/adminPage");
//			return "alert";
//		}
//		System.out.println("아이템 생성 실패");
//		model.addAttribute("status" , "fail");
//		model.addAttribute("msg" , "오류가 발생했습니다. 관리자에게 문의해주세요");
//		model.addAttribute("redirect" , "/admin/adminPage");
		return "alert";
	}
}
