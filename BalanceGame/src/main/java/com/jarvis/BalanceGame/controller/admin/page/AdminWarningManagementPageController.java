package com.jarvis.BalanceGame.controller.admin.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.PageInfoDTO;
import com.jarvis.BalanceGame.model.dto.WarningDTO;
import com.jarvis.BalanceGame.service.LetterService;
import com.jarvis.BalanceGame.service.PageInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminWarningManagementPageController {
	
	@Autowired
	private LetterService letterService;

	@Autowired
	private PageInfoService pageInfoService;
	
	@GetMapping("/warningManagementPage")
	public String adminAdvertisementManagementController(WarningDTO aDTO,PageInfoDTO pDTO, MemberDTO mDTO, Model model, LetterDTO lDTO, HttpSession session) {
		System.out.println("관리자 신고관리 페이지 이동");
		String loginId = (String)session.getAttribute("loginId");
		if(loginId == null) {
			loginId = "admin"; // 관리자 아이디 고정 
		}
		
		if(pDTO.getCurrentPage() == 0) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<");
			pDTO.setCurrentPage(1);
		}
		
		pDTO.setLoginId(loginId);
		pDTO.setPasingnationSize(10);

		pDTO.setOffset(pageInfoService.calculateOffset(pDTO));
		System.out.println(pDTO.getOffset());
		pDTO.setSearchCondition("viewAllReportMessageAdmin");
		System.out.println("pDTO" + pDTO);
		List<PageInfoDTO> datas = pageInfoService.selectAll(pDTO);
		

		lDTO.setLetterType("REPORT");
		lDTO.setSearchCondition("messageCntAdmin");
		lDTO = letterService.selectOne(lDTO);
		System.out.println(lDTO);
		pDTO.setTotalRows(lDTO.getCnt());
		int totalPage = pageInfoService.calcTotalPages(pDTO);	// 총페이지 수
		
		System.out.println(totalPage);
		
			model.addAttribute("letterDatas", datas);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("page", pDTO.getCurrentPage());


		return "admin/adminWarningManagement";
	}
	
}
