package com.jarvis.BalanceGame.controller.admin.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.PageInfoDTO;
import com.jarvis.BalanceGame.model.dto.PaymentDTO;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.PageInfoService;
import com.jarvis.BalanceGame.service.PaymentService;

import jakarta.servlet.http.HttpSession;

@Controller
 @RequestMapping("/admin")
  public class AdminPaymentPageController {
  
  	@Autowired
  	private PaymentService paymentService;
  	@Autowired
  	private MemberService memberService;
  	@Autowired
  	private PageInfoService pageInfoService;
  	
  	@GetMapping("/paymentManagementPage")
  	public String adminSupportPageController(PaymentDTO pDTO, PageInfoDTO pIDTO,MemberDTO mDTO, Model model, HttpSession session) {
  		String loginId = (String)session.getAttribute("loginId");
  		System.out.println("관리자 결제 관리 페이지 이동");
  		
  		if(pIDTO.getCurrentPage() == 0) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<");
			pIDTO.setCurrentPage(1);
		}
		
  		pIDTO.setLoginId(loginId);
  		pIDTO.setPasingnationSize(10);
		
  		pIDTO.setOffset(pageInfoService.calculateOffset(pIDTO));
		System.out.println(pIDTO.getOffset());
		pIDTO.setSearchCondition("ranking");
		System.out.println("pDTO" + pDTO);
		List<PageInfoDTO> datas = pageInfoService.selectAll(pIDTO);
  		
		pDTO.setSearchCondition("viewCnt");
		pDTO = paymentService.selectOne(pDTO);
		System.out.println(pDTO);
		pIDTO.setTotalRows(pDTO.getCnt());
		int totalPage = pageInfoService.calcTotalPages(pIDTO);	// 총페이지 수
  		
		pDTO.setSearchCondition("viewOnepaymentTotal");
		PaymentDTO totalAmount = paymentService.selectOne(pDTO);
		if(datas != null) {
			model.addAttribute("memberDatas", datas);
			model.addAttribute("totalPage", totalPage);
	  		model.addAttribute("totalAmount", totalAmount);
			model.addAttribute("page", pIDTO.getCurrentPage());
		}else {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "등록된 정보가 없습니다.");
			model.addAttribute("redirect", "/adminPaymentManagement");
			return "alert";
		}

  		return "admin/adminPaymentManagement";
  	}
  	
  	
  }

