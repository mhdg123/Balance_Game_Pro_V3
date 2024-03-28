package com.jarvis.BalanceGame.service;

import com.jarvis.BalanceGame.model.dto.MemberDTO;

import jakarta.mail.internet.MimeMessage;

public interface SendMemberIdService {
	
	// 메시지 작성
	public MimeMessage createMessage(MemberDTO mDTO);
	
	// 메일발송
	public void sendMessage(MemberDTO mDTO);
}
