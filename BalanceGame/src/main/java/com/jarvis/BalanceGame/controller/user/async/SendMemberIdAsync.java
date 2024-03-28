package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.SendMemberIdService;

@Controller
@RequestMapping("/user")
public class SendMemberIdAsync {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private SendMemberIdService sendMemberIdService;
	
	@PostMapping("/isIdInfoCorrect")
	public @ResponseBody boolean sendMemberIdAsync(@RequestBody MemberDTO mDTO) {
		
		System.out.println(mDTO);
		
		mDTO.setSearchCondition("isIdInfoCorrect");
		mDTO = memberService.selectOne(mDTO);
		if(mDTO != null) {
			sendMemberIdService.sendMessage(mDTO);
			return true;
		}
		return false;
	}
}
