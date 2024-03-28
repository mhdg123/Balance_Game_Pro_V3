package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.SendTempPwServiceImpl;

@Controller
@RequestMapping("/user")
public class SendTempPwAsync {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private SendTempPwServiceImpl tempPwService;

	@PostMapping("/isTempPwInfoCorrect")
	public @ResponseBody boolean sendTempPwAsync(@RequestBody MemberDTO mDTO, Gson gson) {
		System.out.println(mDTO);
		mDTO.setSearchCondition("isTempPwInfoCorrect");
		mDTO = memberService.selectOne(mDTO);
		System.out.println(mDTO);
		if(mDTO != null) {
			String code = tempPwService.sendEmail(mDTO);
			// 해당 코드로 회원 비밀번호 설정
			mDTO.setMemberPassword(code);
			mDTO.setSearchCondition("updateTempPw");
			boolean flag = memberService.update(mDTO);
			if(flag) {
				return true;
			}
		}
		return false;
	}
}
