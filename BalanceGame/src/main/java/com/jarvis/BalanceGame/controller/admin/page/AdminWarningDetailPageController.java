package com.jarvis.BalanceGame.controller.admin.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.CommentDTO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.WarningDTO;
import com.jarvis.BalanceGame.service.CommentService;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.WarningService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminWarningDetailPageController {

	@Autowired
	private WarningService warningService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/warningDetailPage")
	public String adminAdvertisementManagementController(WarningDTO wDTO,MemberDTO mDTO, CommentDTO cDTO, Model model, HttpSession session) {
		System.out.println("관리자 신고 상세페이지 이동");
		System.out.println(mDTO.getLoginId()+"<<<<<<<<<<<<<<<<<<<<<");
		mDTO.setSearchCondition("viewOne");
		System.out.println(mDTO+"<<<<<<<<<!!!!!!!!!!!!!!!!");
		mDTO = memberService.selectOne(mDTO);
		System.out.println("신고당한 유저 아이디  : " + mDTO);
		   if(mDTO == null) { 
	            model.addAttribute("status", "fail");
	            model.addAttribute("msg", "탈퇴한 회원입니다.");
	            model.addAttribute("redirect", "/admin/warningManagementPage");
	            return "alert";
	        }
		//신고 당한 댓글 출력
		String loginId = mDTO.getLoginId();
		wDTO.setCommentWriter(loginId);
		wDTO.setSearchCondition("reportedComments");
		List<WarningDTO> datas = warningService.selectAll(wDTO);
		model.addAttribute("memberData", mDTO);
		model.addAttribute("commentDatas", datas);
		
		return "admin/adminWarningDetail";
	}
	
}
