package com.jarvis.BalanceGame.controller.user.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.CommentDTO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.MemberItemDTO;
import com.jarvis.BalanceGame.service.CommentService;
import com.jarvis.BalanceGame.service.MemberItemService;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class MyPageController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberItemService memberItemService;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/myInfoPage")
	public String myPageController(MemberDTO mDTO, CommentDTO cDTO, Model model,MemberItemDTO miDTO, HttpSession session) {
		System.out.println("마이페이지 들어옴");
		mDTO.setLoginId((String)session.getAttribute("loginId"));
		miDTO.setLoginId((String)session.getAttribute("loginId"));
		cDTO.setLoginId((String)session.getAttribute("loginId"));
		
		mDTO.setSearchCondition("myInfo");
		System.out.println(session.getAttribute("loginId"));
		System.out.println(memberService.selectOne(mDTO));
		model.addAttribute("memberData", memberService.selectOne(mDTO));
		
		cDTO.setSearchCondition("userComments");
		List<CommentDTO> datas = commentService.selectAll(cDTO);
		
		List<MemberItemDTO> midatas = memberItemService.selectAll(miDTO);
		
		model.addAttribute("commentDatas", datas);
		model.addAttribute("memberItemDatas", midatas);
		System.out.println(datas);
		
		
		return "user/myInfo";
	}
}