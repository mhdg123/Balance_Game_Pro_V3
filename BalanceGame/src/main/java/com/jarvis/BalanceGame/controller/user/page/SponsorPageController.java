package com.jarvis.BalanceGame.controller.user.page;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SponsorPageController {
	
	@Autowired
	private SupportService supportService;
	
	@RequestMapping("/sponsorPage")
	public String SponsorPageController(SupportDTO sDTO, Model model) {
		
		sDTO.setSearchCondition("후원목록");
		ArrayList<sDTO> supportDatas =  supportService.selectAll(sDTO);
		
			model.addAttribute("datas", supportDatas);

		return "sponsor";
	}
}
