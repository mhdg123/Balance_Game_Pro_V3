package com.jarvis.BalanceGame.controller.admin.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.PaymentDTO;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.PaymentService;

@Controller
 @RequestMapping("/admin")
  public class AdminPaymentPageController {
  
  	@Autowired
  	private PaymentService paymentService;
  	@Autowired
  	private MemberService memberService;
  	
  	@GetMapping("/paymentManagementPage")
  	public String adminSupportPageController(PaymentDTO pDTO,MemberDTO mDTO, Model model) {
  		System.out.println("관리자 결제 관리 페이지 이동");
  		mDTO.setSearchCondition("ranking");
  		List<MemberDTO> mdatas = memberService.selectAll(mDTO);
  		
  		PaymentDTO totalAmount = paymentService.selectOne(pDTO);
  		
  		if(mdatas == null) {
  
  			model.addAttribute("status", "fail");
  			model.addAttribute("msg", "해당 데이터가 없습니다");
  			model.addAttribute("redirect", "adminPage");
  			return "alert";
  		}
  		
  		model.addAttribute("memberDatas", mdatas);
  		model.addAttribute("totalAmount", totalAmount);
  		
  
  		return "admin/adminPaymentManagement";
  	}
  	
  	
  }

