package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jarvis.BalanceGame.model.dto.CommentDTO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.CommentService;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("/user")
public class CommentWriteAsync {

	@Autowired
	private MemberService memberService;
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/commentWriteAsync")
	public @ResponseBody String commentWriteAsync(CommentDTO cDTO, MemberDTO mDTO, Model model, HttpSession session, Gson gson) {
		
		cDTO.setLoginId((String)session.getAttribute("loginId"));
		cDTO.setSearchCondition("createComments");
		commentService.insert(cDTO);
		
		mDTO.setSearchCondition("viewOne");
		mDTO.setLoginId((String)session.getAttribute("loginId"));
		mDTO= memberService.selectOne(mDTO);
		
		cDTO.setLoginId(mDTO.getName());
		cDTO.setMemberGrade(mDTO.getGrade());
		
		String json =gson.toJson(cDTO);
		System.out.println(json);
		
		return gson.toJson(cDTO);
	}
}


