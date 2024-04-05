package com.jarvis.BalanceGame.controller.admin.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminCommentStopController {

	@Autowired
	private MemberService memberService;
	// commentStatus
	@PostMapping("/adminCommentStopAsync")
	public String adminCommentStopAsync(MemberDTO mDTO) {
		System.out.println("qlesadfasdfasdfsdafsda");
		System.out.println("댓글 권한 데이터 : " + mDTO.getWriteStatus());
		System.out.println("댓글 권한 유저 데이터 : " + mDTO.getLoginId());
		mDTO.setSearchCondition("viewOne");
		MemberDTO data =  memberService.selectOne(mDTO);
		System.out.println("데이터 1111111111 :  " + data.getWriteStatus());
		if (mDTO.getWriteStatus().equals("T")) {
			System.out.println("F로 바뀜");
			mDTO.setSearchCondition("updateCommentStatusF");
			memberService.update(mDTO);
			return "F";
		} else if (mDTO.getWriteStatus().equals("F")) {
			System.out.println("T로 바뀜");
			mDTO.setSearchCondition("updateCommentStatusT");
			memberService.update(mDTO);
		}
		return "T";
	}
}
