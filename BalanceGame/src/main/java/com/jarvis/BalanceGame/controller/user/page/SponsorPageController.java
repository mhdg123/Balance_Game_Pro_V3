package com.jarvis.BalanceGame.controller.user.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.PaymentDTO;
import com.jarvis.BalanceGame.service.PaymentService;

@Controller
@RequestMapping("/user")
public class SponsorPageController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/sponsorPage")
	public String sponsorPageController(PaymentDTO pDTO, Model model) {
		
		pDTO.setSearchCondition("후원목록");
		
		List<pDTO> supportDatas =  paymentService.selectAll(pDTO);
		
			model.addAttribute("datas", supportDatas);

		return "/user/sponsor";
	}
}
