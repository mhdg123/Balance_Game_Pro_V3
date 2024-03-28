package com.jarvis.BalanceGame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dto.MemberDTO;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class SendMemberIdServiceImpl implements SendMemberIdService {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public MimeMessage createMessage(MemberDTO mDTO) {

		System.out.println("메일 받을 회원" + mDTO.getEmail());
		String msg = "";
		msg += "<h1>BALANCE GAME 입니다</h1>";
		msg += "<br>";
		msg += "<h2>" + mDTO.getNickName() + "님, 안녕하세요</h2>";
		msg += "<br>";
		msg += "<br>";
		msg += "<div align='center' style='border:1px solid black'>";
		msg += "<h3 style='color:blue'>해당 아래 아이디로 로그인 바랍니다</h3>";
		msg += "<div style='font-size:130%'><strong>";
		msg += mDTO.getLoginId() + "</strong></div><br/>";
		msg += "</div>";

		MimeMessage message = mailSender.createMimeMessage();
		try {
			message.setFrom(new InternetAddress("qkrgusrngus@naver.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mDTO.getEmail()));
			message.setSubject("회원 아이디를 보내드립니다 - BLALANCE GAME");
			message.setText(msg, "UTF-8", "html");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public void sendMessage(MemberDTO mDTO) {
		MimeMessage message = createMessage(mDTO);

		try {
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
