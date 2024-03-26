package com.jarvis.BalanceGame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService implements MailServiceImpl {

	@Autowired
	private JavaMailSender emailSender; // MailConfig에서 등록해둔 Bean을 autowired하여 사용하기

	@Override
	public MimeMessage createMessage(QuestionDTO qDTO) {

		System.out.println("메일을 받을 회원: " + qDTO.getEmail());
		String msg = "";
		msg += "<h1>"+qDTO.getWriter()+"님 안녕하세요</h1>";
		msg += "<h1>BALANCE GAME 입니다</h1>";
		msg += "<br>";
		msg += "<p>문제를 출제해주셔서 감사합니다.</p>";
		msg += "<br>";
		msg += "<br>";
		msg += "<div align='center' style='border:1px solid black'>";
		msg += "<h3 style='color:blue'>아쉽지만 민감한 문제로 인하여 귀하의 문제는 채택되지 않았습니다. </h3>";
		msg += "<div style='font-size:130%'>";
		msg += "다음에 다시 이용부탁드립니다</div><br/>"; 
		msg += "</div>";

		MimeMessage message = emailSender.createMimeMessage();
		try {
			message.setFrom(new InternetAddress("qkrgusrngus@naver.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(qDTO.getEmail()));
			message.setSubject("문제를 출제해주셔서 감사합니다");
			message.setText(msg, "UTF-8", "html");
			emailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}

	@Override
	public void sendMessage(QuestionDTO qDTO) {

		System.out.println(qDTO);
		
		MimeMessage message = createMessage(qDTO); // "to" 로 메일 발송
		System.out.println(message);
		System.out.println(qDTO);
		System.out.println("********생성된 메시지******** => " + message);

		try { // 예외처리

			emailSender.send(message);

		} catch (Exception e) {

			e.printStackTrace();

			throw new IllegalArgumentException();

		}
		
	}

}
