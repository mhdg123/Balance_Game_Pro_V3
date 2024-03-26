package com.jarvis.BalanceGame.service;

import com.jarvis.BalanceGame.model.dto.MemberDTO;

import jakarta.mail.internet.MimeMessage;

public interface SendTempPwServiceImpl {
	
	// 메일작성
	public MimeMessage createMessage(MemberDTO mDTO);
	
	// 임시비밀번호 작성
	public String tempPassword();
	
	// 메일 보내기 
	public String sendEmail(MemberDTO mDTO);
}
