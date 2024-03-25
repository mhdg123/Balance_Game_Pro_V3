package com.jarvis.BalanceGame;

import jakarta.mail.internet.MimeMessage;

public interface MailServiceImpl {

	// 메일 작성
	public MimeMessage createMessage(String to);
	
	// 메일 발송
	public void sendMessage(String to);
}
