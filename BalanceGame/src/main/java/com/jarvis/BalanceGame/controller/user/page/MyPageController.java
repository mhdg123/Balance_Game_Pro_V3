package com.jarvis.BalanceGame.controller.user.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.CommentDTO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.CommentService;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class MyPageController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/myInfoPage")
	public String myPageController(MemberDTO mDTO, CommentDTO cDTO, Model model, HttpSession session) {
		System.out.println("마이페이지 들어옴");
		mDTO.setLoginId((String)session.getAttribute("loginId"));
		cDTO.setLoginId((String)session.getAttribute("loginId"));
		mDTO.setSearchCondition("myInfo");
		System.out.println(session.getAttribute("loginId"));
		System.out.println(memberService.selectOne(mDTO));
//		System.out.println(memberService.selectOne(mDTO).getLoginId());
		model.addAttribute("memberData", memberService.selectOne(mDTO));
		
		cDTO.setSearchCondition("userComments");
		List<CommentDTO> datas = commentService.selectAll(cDTO);

		model.addAttribute("commentDatas", datas);
		System.out.println(datas);
		
		
		return "user/myInfo";
	}
}