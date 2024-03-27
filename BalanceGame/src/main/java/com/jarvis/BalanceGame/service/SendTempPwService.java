package com.jarvis.BalanceGame.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dto.MemberDTO;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class SendTempPwService implements SendTempPwServiceImpl {

	@Autowired
	private JavaMailSender emailSender;

	private String tempPassword = "";

	@Override
	public MimeMessage createMessage(MemberDTO mDTO) {

		System.out.println("메일 받을 회원" + mDTO.getEmail());
		String msg = "";
		msg += "<h1>BALANCE GAME 입니다</h1>";
		msg += "<br>";
		msg += "<p>임시 비밀번호를 보내드립니다</p>";
		msg += "<br>";
		msg += "<br>";
		msg += "<div align='center' style='border:1px solid black'>";
		msg += "<h3 style='color:blue'>해당 아래 임시비밀번호로 로그인 후 다른 비밀번호로 바꾸길 권장드립니다</h3>";
		msg += "<div style='font-size:130%'><strong>";
		msg += tempPassword + "</strong></div><br/>";
		msg += "</div>";

		MimeMessage message = emailSender.createMimeMessage();
		try {
			message.setFrom(new InternetAddress("qkrgusrngus@naver.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mDTO.getEmail()));
			message.setSubject("임시 비밀번호입니다 - BLALANCE GAME");
			message.setText(msg, "UTF-8", "html");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String tempPassword() {
		StringBuilder tempPw = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < 8; i++) { // 인증코드 8자리
			int index = random.nextInt(3); // 0~2 까지 랜덤, rnd 값에 따라서 아래 switch 문이 실행됨

			switch (index) {
			case 0:
				tempPw.append((char) (random.nextInt(26) + 97));
				// a~z (ex. 1+97=98 => (char)98 = 'b')
				break;
			case 1:
				tempPw.append((char) (random.nextInt(26) + 65));
				// A~Z
				break;
			case 2:
				tempPw.append((random.nextInt(10)));
				// 0~9
				break;
			}
		}

		return tempPw.toString();
	}

	@Override
	public String sendEmail(MemberDTO mDTO) {

		tempPassword = tempPassword();
		MimeMessage message = createMessage(mDTO);

		try {
			emailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempPassword;
	}
}
