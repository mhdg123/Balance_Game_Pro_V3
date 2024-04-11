package com.jarvis.BalanceGame.controller.admin.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.PageInfoDTO;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.PageInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminMemberManagementPageController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PageInfoService pageInfoService;
	// 회원 관리 페이지로 이동
	@GetMapping("/memberManagementPage")
	public String adminMemberManagementPageController(MemberDTO mDTO, PageInfoDTO pDTO, Model model, HttpSession session) {
		
		String loginId = (String)session.getAttribute("loginId");
		
		if(pDTO.getCurrentPage() == 0) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<");
			pDTO.setCurrentPage(1);
		}
		
		pDTO.setLoginId(loginId);
		pDTO.setPasingnationSize(10);
		
		pDTO.setOffset(pageInfoService.calculateOffset(pDTO));
		System.out.println(pDTO.getOffset());
		pDTO.setSearchCondition("viewAllOfMemberList");
		System.out.println("pDTO" + pDTO);
		List<PageInfoDTO> datas = pageInfoService.selectAll(pDTO);
		
		
		// 회원 수 세기
		mDTO.setSearchCondition("memberCnt");
		mDTO = memberService.selectOne(mDTO);
		System.out.println(mDTO);
		pDTO.setTotalRows(mDTO.getMemberCount());
		int totalPage = pageInfoService.calcTotalPages(pDTO);	// 총페이지 수
		
		if(datas != null) {
			model.addAttribute("memberDatas", datas);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("page", pDTO.getCurrentPage());
		}else {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "등록된 회원이 없습니다.");
			model.addAttribute("redirect", "");
			return "alert";
		}

		return "admin/adminMemberManagement";
	}
		
}