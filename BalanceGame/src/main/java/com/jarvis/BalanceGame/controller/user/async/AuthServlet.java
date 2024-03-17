package com.jarvis.BalanceGame.controller.user.async;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.MemberDTO;


@Controller
@RequestMapping("/user")
public class AuthServlet {

	@PostMapping("/messageApi")
	public @ResponseBody String authServlet(MemberDTO memberDTO) {
		System.out.println("문자 인증 기능 실행");
		Random rand = new Random();
		int randNum = rand.nextInt(900000) + 100000;

		String phone = memberDTO.getCellPhone();
		String authNumber = String.valueOf(randNum);


		// 생성된 인증번호를 text 형식으로 전송

//      돈 나갈예정이라 막아놓음
//		DefaultMessageService messageService = NurigoApp.INSTANCE.initialize("NCS6ZHPOOM5UZPWE", "UG5ONIDCC9V05JCNXNXFSMYYZOMHCYOH", "https://api.coolsms.co.kr"); // Message
//		Message message = new Message();
//		message.setFrom("01087937953");
//		message.setTo(phone);
//		message.setText(authNumber);

//		try { // send 메소드로 ArrayList<Message> 객체를 넣어도 동작합니다!
//			messageService.send(message);
//		} catch (NurigoMessageNotReceivedException exception) { // 발송에 실패한 메시지 목록을 확인할 수 있습니다!
//			System.out.println(exception.getFailedMessageList());
//			System.out.println(exception.getMessage());
//		} catch (Exception exception) {
//			System.out.println(exception.getMessage());
//		}
		
		return authNumber;
	}
}