//package com.jarvis.BalanceGame.controller.admin.page;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class AdminSupportPageController {
//
//	@Autowired
//	private SupportService supportService;
//	
//	@RequestMapping("/adminSponsor")
//	public String AdminSupportPageController(SupportDTO sDTO, Model model) {
//		
//		sDTO.setSearchCondition("후원순");
//		List<SupportDTO> sdatas = supportService.selectAll(sDTO);
//		
//		sDTO.setSearchCondition("총후원금액");
//		SupportDTO totalAmount = supportService.selectOne(sDTO);
//		
//		if(sdatas == null) {
//
//			model.addAttribute("status", "fail");
//			model.addAttribute("msg", "해당 데이터가 없습니다");
//			model.addAttribute("redirect", "adminPage.do");
//			return "alert";
//		}
//		
//		model.addAttribute("sdatas", sdatas);
//		model.addAttribute("totalAmount", totalAmount);
//		
//
//		return "adminSponsor";
//	}
//	
//	
//}
