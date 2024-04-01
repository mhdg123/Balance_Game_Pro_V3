package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.SendMemberIdService;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Controller
@RequestMapping("/user")
public class SendMemberIdAsync {

	@Autowired
	private MemberService memberService;

	@Autowired
	private SendMemberIdService sendMemberIdService;

	@PostMapping("/isIdInfoCorrect")
	public @ResponseBody boolean sendMemberIdAsync(@RequestBody MemberDTO mDTO) {

		System.out.println(mDTO);

		mDTO.setSearchCondition("isIdInfoCorrect");
		mDTO = memberService.selectOne(mDTO);
		if (mDTO != null) {
			sendMemberIdService.sendMessage(mDTO);
			return true;
		}
		return false;
	}

	@PostMapping("/sendMemberIdNumberAsync")
	public @ResponseBody String sendMemberIdNumberAsync(@RequestBody MemberDTO mDTO) {
		System.out.println("전화번호로 아이디 찾기 이름 데이터 : " + mDTO.getName());
		System.out.println("전화번호로 아이디 찾기 전화번호 데이터 : " + mDTO.getCellPhone());
		System.out.println("문자 인증 기능 실행");

		mDTO.setSearchCondition("isIdInfoCorrectCellPhone");
		mDTO = memberService.selectOne(mDTO);
		if (mDTO != null) {
			sendMemberIdService.sendMessage(mDTO);
			return "fail";
		}

		String phone = mDTO.getCellPhone();
		String userId = mDTO.getLoginId();

		DefaultMessageService messageService = NurigoApp.INSTANCE.initialize("NCS6ZHPOOM5UZPWE",
				"UG5ONIDCC9V05JCNXNXFSMYYZOMHCYOH", "https://api.coolsms.co.kr"); // Message
		Message message = new Message();
		message.setFrom("01087937953");
		message.setTo(phone);
		message.setText(userId);

		try { // send 메소드로 ArrayList<Message> 객체를 넣어도 동작합니다!
			messageService.send(message);
		} catch (NurigoMessageNotReceivedException exception) { // 발송에 실패한 메시지 목록을 확인할 수 있습니다!
			System.out.println(exception.getFailedMessageList());
			System.out.println(exception.getMessage());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		System.out.println("문자 아이디: " + userId);
		return "success";

	}
}
