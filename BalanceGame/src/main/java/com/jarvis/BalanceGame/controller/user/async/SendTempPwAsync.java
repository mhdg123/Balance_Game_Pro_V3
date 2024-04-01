package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.SendTempPwService;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Controller
@RequestMapping("/user")
public class SendTempPwAsync {

	@Autowired
	private MemberService memberService;

	@Autowired
	private SendTempPwService tempPwService;

	@PostMapping("/isTempPwInfoCorrect")
	public @ResponseBody boolean sendTempPwAsync(@RequestBody MemberDTO mDTO) {
		System.out.println(mDTO);
		mDTO.setSearchCondition("isTempPwInfoCorrect");
		mDTO = memberService.selectOne(mDTO);
		System.out.println(mDTO);
		if (mDTO != null) {
			String code = tempPwService.sendEmail(mDTO);
			// 해당 코드로 회원 비밀번호 설정
			mDTO.setMemberPassword(code);
			mDTO.setSearchCondition("updateTempPw");
			boolean flag = memberService.update(mDTO);
			if (flag) {
				return true;
			}
		}
		return false;
	}

	@PostMapping("sendMemberPwNumberAsync")
	public @ResponseBody String sendMemberPwNumberAsync(@RequestBody MemberDTO mDTO) {
		System.out.println("전화번호로 비번 찾기 이름 데이터 : " + mDTO.getLoginId());
		System.out.println("전화번호로 아이디 찾기 전화번호 데이터 : " + mDTO.getCellPhone());
		System.out.println("문자 인증 기능 실행");

		mDTO.setSearchCondition("isTempPwInfoCorrectCellPhone");
		mDTO = memberService.selectOne(mDTO);
		if (mDTO.getLoginType().equals("SOCIAL")) {
			return "social";
		}

		String phone = mDTO.getCellPhone();
		String userPassword = mDTO.getMemberPassword();

		if (mDTO != null) {
			String code = tempPwService.sendEmail(mDTO);
			// 해당 코드로 회원 비밀번호 설정
			mDTO.setMemberPassword(code);
			mDTO.setSearchCondition("updateTempPw");
			boolean flag = memberService.update(mDTO);
			DefaultMessageService messageService = NurigoApp.INSTANCE.initialize("NCS6ZHPOOM5UZPWE",
					"UG5ONIDCC9V05JCNXNXFSMYYZOMHCYOH", "https://api.coolsms.co.kr"); // Message
			Message message = new Message();
			message.setFrom("01087937953");
			message.setTo(phone);
			message.setText(code);

			try { // send 메소드로 ArrayList<Message> 객체를 넣어도 동작합니다!
				messageService.send(message);
			} catch (NurigoMessageNotReceivedException exception) { // 발송에 실패한 메시지 목록을 확인할 수 있습니다!
				System.out.println(exception.getFailedMessageList());
				System.out.println(exception.getMessage());
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}

			System.out.println("문자 아이디: " + userPassword);
			return "success";
		}
		return "fail";
	}
}
