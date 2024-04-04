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
	
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping("/adminPaymentManageRankAsync")
	public @ResponseBody String adminPaymentManageRankAsync(PageInfoDTO piDTO, Gson gson, PaymentDTO pDTO) {
		if(piDTO.getCurrentPage() == 0) { // 뷰에서 넘겨주는 현재페이지가 0이라면
			piDTO.setCurrentPage(1); // 현재페이지를 1로 설정
		}
		piDTO.setPasingnationSize(10); // 사용자에게 보여줄 페이지 수 
		piDTO.setOffset(pageInfoService.calculateOffset(piDTO)); // 현재 페이지에서 보여줄 페이지 수 
		piDTO.setSearchCondition("ranking");
		List<PageInfoDTO> rankDatas = pageInfoService.selectAll(piDTO); // 결제금액 데이터 
		
		System.out.println("rankDatas"+rankDatas);
		if(rankDatas == null) {
			return "실패";
		}
		
		pDTO.setSearchCondition("viewCnt"); // 총 결제금액한 수 
		pDTO = paymentService.selectOne(pDTO); 
		System.out.println(pDTO);
		piDTO.setTotalRows(pDTO.getCnt());
		int totalPage = pageInfoService.calcTotalPages(piDTO);	// 총페이지 수
		
		
		System.out.println(gson.toJson(rankDatas));
		return gson.toJson(rankDatas);
	}
}
