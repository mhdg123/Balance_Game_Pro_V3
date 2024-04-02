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
		String phone = mDTO.getCellPhone();
		System.out.println("전화번호로 아이디 찾기 이름 데이터 : " + mDTO.getName());
		System.out.println("전화번호로 아이디 찾기 전화번호 데이터 : " + mDTO.getCellPhone());
		System.out.println("문자 인증 기능 실행");

		mDTO.setSearchCondition("isIdInfoCorrectCellPhone");
		mDTO = memberService.selectOne(mDTO);

		if (mDTO == null) { // 찾는 회원정보가 없을때
			return "fail";
		}
		System.out.println("전화번호로 아이디 찾기 조회된 데이터 : " + mDTO);
		if (mDTO != null) { // 찾는 회원정보가 있을때
			if (mDTO.getLoginType().equals("SOCIAL")) { // 찾는 회원이 소셜로그인 일때
				System.out.println("소셜 회원입니다.");
				return "social";
			}

			DefaultMessageService messageService = NurigoApp.INSTANCE.initialize("NCS6ZHPOOM5UZPWE",
					"UG5ONIDCC9V05JCNXNXFSMYYZOMHCYOH", "https://api.coolsms.co.kr");
			Message message = new Message();
			message.setFrom("01087937953");
			message.setTo(phone);
			message.setText("회원님의 아이디는 : " + "[" +  mDTO.getLoginId() +"] 입니다.");

			try {
				messageService.send(message);
				System.out.println("문자 아이디: " + mDTO.getLoginId());
			} catch (NurigoMessageNotReceivedException exception) {
				System.out.println(exception.getFailedMessageList());
				System.out.println(exception.getMessage());
				return "fail";
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
				return "fail";
			}
		}
		return "success";
	}

}
