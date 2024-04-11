
package com.jarvis.BalanceGame.controller.admin.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.CommentDTO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.PageInfoDTO;
import com.jarvis.BalanceGame.service.CommentService;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.PageInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminMemberDetailPageController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private PageInfoService pageInfoService;

	// 회원 관리 상세 페이지로 이동
	@GetMapping("/adminMemberDetailPage")
	public String adminMemberDetailPageController(MemberDTO mDTO, PageInfoDTO pDTO, CommentDTO cDTO, Model model,
			HttpSession session) {
		System.out.println("관리자에서 유저 상세페이지 이동 ");
		mDTO.setSearchCondition("viewOne");
		cDTO.setSearchCondition("userComments");
		MemberDTO member = memberService.selectOne(mDTO);

		if (pDTO.getCurrentPage() == 0) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<");
			pDTO.setCurrentPage(1);
		}

		pDTO.setPasingnationSize(10);

		pDTO.setOffset(pageInfoService.calculateOffset(pDTO));
		System.out.println(pDTO.getOffset());
		pDTO.setSearchCondition("userComments");
		System.out.println("pDTO" + pDTO);
		List<PageInfoDTO> datas = pageInfoService.selectAll(pDTO);

		cDTO.setSearchCondition("commentsCntMember");
		cDTO = commentService.selectOne(cDTO);
		System.out.println(cDTO);
		pDTO.setTotalRows(cDTO.getCnt());
		int totalPage = pageInfoService.calcTotalPages(pDTO); // 총페이지 수

		System.out.println(totalPage);

		if (member == null) {
			model.addAttribute("status", "fail");
			model.addAttribute("fail", "회원이 존재하지 않습니다.");
			model.addAttribute("redirect", "/admin/memberManagementPage");
			return "alert";
		}

		model.addAttribute("commentDatas", datas);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("page", pDTO.getCurrentPage());
		model.addAttribute("memberData", member);

		return "admin/adminMemberDetail";
	}
}
