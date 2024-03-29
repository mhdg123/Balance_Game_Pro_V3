package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.WarningDTO;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.WarningService;

@Controller
@RequestMapping("/user")
public class CommentReportAsync {

	
	@Autowired
	private WarningService warningService;
	
	@Autowired
	private MemberService memberService;
	
	
	
	@PostMapping("/CommentReportAsync")
	public @ResponseBody String commentReportAsync(WarningDTO wDTO, MemberDTO mDTO) {
		// 신고자하고 댓글 id 비교
		wDTO = warningService.selectOne(wDTO);
		if(wDTO == null) {
			// 데이터가 없으면 추가
			warningService.insert(wDTO);
			return "success";
		}
		else {
			// 데이터가 이미 있다면 실패
			return "fail";
		}
		
		//셀렉하기
		// 신고하는 유저하고
		// 댓글 pk 확인하기
		// 한번만 가능하게 하기
	}
}
