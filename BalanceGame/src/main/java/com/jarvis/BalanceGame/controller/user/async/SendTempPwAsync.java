package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.SendTempPwService;

@Controller
@RequestMapping("/user")
public class SendTempPwAsync {
	
	@Autowired
	private SendTempPwService tempPwService;
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/sendTempPwAsync")
	public String mailConfirm(@RequestParam("loginId") String loginId, MemberDTO mDTO) {
		
		// 해당 전달받은 아이디로 아이디와 이메일을 조회
		mDTO = memberService.selectOne(mDTO);
		String code = tempPwService.sendEmail(mDTO);
		
		// 전달받은 코드를 회원의 비밀번호로 설정 
		return "login";
	}
}		
