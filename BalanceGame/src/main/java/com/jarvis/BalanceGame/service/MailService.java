package com.jarvis.BalanceGame.service;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;

import jakarta.mail.internet.MimeMessage;

public interface MailService {

	// 메일 작성
	public MimeMessage createMessage(QuestionDTO qDTO);
	
	// 메일 발송
	public void sendMessage(QuestionDTO qDTO);
}
