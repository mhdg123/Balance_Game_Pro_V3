package com.jarvis.BalanceGame.controller.admin.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.PaymentDTO;
import com.jarvis.BalanceGame.service.PaymentService;

@Controller
@RequestMapping("/admin")
public class AdminChartManagementPageController {

	@Autowired
	private PaymentService paymentService;

	// 통계차트 관리 페이지로 이동
	@GetMapping("/adminChartManagementPage")
	public String adminCreateTitlePageController(PaymentDTO pDTO, Model model) {
		System.out.println("관리자 통계차트 관리 페이지 이동");

		
		return "admin/adminChartManagement";
	}

}
