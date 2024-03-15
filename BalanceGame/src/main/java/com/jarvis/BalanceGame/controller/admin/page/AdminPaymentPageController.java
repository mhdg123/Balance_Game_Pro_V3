//package com.jarvis.BalanceGame.controller.admin.page;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.jarvis.BalanceGame.model.dto.PaymentDTO;
//import com.jarvis.BalanceGame.service.PaymentService;
//
//@Controller
// @RequestMapping("/admin")
//  public class AdminPaymentPageController {
//  
//  	@Autowired
//  	private PaymentService paymentService;
//  	
//  	@GetMapping("/paymentManagementPage")
//  	public String adminSupportPageController(PaymentDTO pDTO, Model model) {
//  		
//  		pDTO.setSearchCondition("후원순");
//  		List<PaymentDTO> sdatas = paymentService.selectAll(pDTO);
//  		
//  		sDTO.setSearchCondition("총후원금액");
//  		PaymentDTO totalAmount = paymentService.selectOne(pDTO);
//  		
//  		if(sdatas == null) {
//  
//  			model.addAttribute("status", "fail");
//  			model.addAttribute("msg", "해당 데이터가 없습니다");
//  			model.addAttribute("redirect", "adminPage");
//  			return "alert";
//  		}
//  		
//  		model.addAttribute("sdatas", sdatas);
//  		model.addAttribute("totalAmount", totalAmount);
//  		
//  
//  		return "admin/paymentManagementPage";
//  	}
//  	
//  	
//  }
//
