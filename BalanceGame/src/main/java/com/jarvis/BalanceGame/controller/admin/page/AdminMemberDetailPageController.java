
package com.jarvis.BalanceGame.controller.admin.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.CommentDTO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.CommentService;
import com.jarvis.BalanceGame.service.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminMemberDetailPageController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private CommentService commentService;

	@GetMapping("/adminMemberDetailPage")
	public String AdminMemberDetailPageController(MemberDTO mDTO, CommentDTO cDTO, Model model) {

		mDTO.setSearchCondition("유저조회");
		cDTO.setSearchCondition("유저댓글조회");

		List<CommentDTO> cdatas = commentService.selectAll(cDTO);

		MemberDTO member = memberService.selectOne(mDTO);

		if (member == null) {
			model.addAttribute("status", "fail");
			model.addAttribute("fail", "회원이 존재하지 않습니다.");
			model.addAttribute("redirect", "adminPage");
			return "alert";
		}

		model.addAttribute("member", member);
		model.addAttribute("cdatas", cdatas);
		System.out.println("로그 cdatas[" + cdatas + "]");
		System.out.println("로그 member[" + member + "]");

		return "adminMemberDetail";
	}
}
