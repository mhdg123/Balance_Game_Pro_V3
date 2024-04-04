package com.jarvis.BalanceGame.controller.admin.async;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jarvis.BalanceGame.model.dto.PageInfoDTO;
import com.jarvis.BalanceGame.model.dto.PaymentDTO;
import com.jarvis.BalanceGame.service.PageInfoService;
import com.jarvis.BalanceGame.service.PaymentService;

@Controller
@RequestMapping("/admin")
public class AdminPaymentManageRankAsync {

	@Autowired
	private PageInfoService pageInfoService;
	
	@RequestMapping("/adminPaymentManageRankAsync")
	public @ResponseBody String adminPaymentManageRankAsync(PageInfoDTO piDTO, Gson gson) {
		
		piDTO.setSearchCondition("ranking");
		List<PageInfoDTO> rankDatas = pageInfoService.selectAll(piDTO);
		System.out.println("rankDatas"+rankDatas);
		if(rankDatas == null) {
			return "실패";
		}
		System.out.println(gson.toJson(rankDatas));
		return gson.toJson(rankDatas);
	}
}
