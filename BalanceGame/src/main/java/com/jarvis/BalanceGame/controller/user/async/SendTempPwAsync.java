package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.SendTempPwService;

import jakarta.servlet.http.HttpSession;
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
		
		mDTO.setSearchCondition("isTempPwInfoCorrectCellPhone");
		
		System.out.println(mDTO);
		if (memberService.selectOne(mDTO) != null) {
			System.out.println(mDTO);
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

	
	@PostMapping("/isEmailCodeCorrect")
	public @ResponseBody String emailCodeAsync(MemberDTO mDTO,HttpSession session) {
		mDTO.setLoginId((String)session.getAttribute("loginId"));

		System.out.println(mDTO);

			mDTO.setSearchCondition("isEmailCodeCorrect");
			System.out.println(mDTO);
			String code = tempPwService.sendEmail(mDTO);
			

			return code;

	}

	@PostMapping("/sendMemberPwNumberAsync")
	public @ResponseBody String sendMemberPwNumberAsync(@RequestBody MemberDTO mDTO) {
		System.out.println("전화번호로 비번 찾기 이름 데이터 : " + mDTO.getLoginId());
		System.out.println("전화번호로 아이디 찾기 전화번호 데이터 : " + mDTO.getCellPhone());
		System.out.println("문자 인증 기능 실행");

		mDTO.setSearchCondition("isTempPwInfoCorrectCellPhone");
		mDTO = memberService.selectOne(mDTO);
		if (mDTO.getLoginType().equals("SOCIAL")) {
			return "social";
		}
		System.out.println("조회된 회원 데이터 :  " + mDTO);
		String phone = mDTO.getCellPhone();
		String password = tempPwService.tempPassword(); // 바뀔 임시 비밀번호

		if (mDTO != null) {
			String code = "";
			code += "임시 비밀번호 : [ ";
			code += password; // 임시비밀번호
			code += " ]   으로 로그인 시도해 주세요";
			// 해당 코드로 회원 비밀번호 설정
			mDTO.setMemberPassword(password); // 임시비밀번호 설정
			mDTO.setSearchCondition("updateTempPw");
			boolean flag = memberService.update(mDTO); // 임시비밀번호로 수정
			if (flag) { // 수정이 성공적으로 되었으면 임시비밀번호를 회원에게 문자 발송
				DefaultMessageService messageService = NurigoApp.INSTANCE.initialize("NCS6ZHPOOM5UZPWE",
						"UG5ONIDCC9V05JCNXNXFSMYYZOMHCYOH", "https://api.coolsms.co.kr"); // Message
				Message message = new Message();
				message.setFrom("01087937953");
				message.setTo(phone); // 회원 전화번호
				message.setText(code); // 문자발송 메세지 내용

				try { // send 메소드로 ArrayList<Message> 객체를 넣어도 동작합니다!
					System.out.println("문자 발송 성공");
					messageService.send(message);
				} catch (NurigoMessageNotReceivedException exception) { // 발송에 실패한 메시지 목록을 확인할 수 있습니다!
					System.out.println(exception.getFailedMessageList());
					System.out.println(exception.getMessage());
					return "fail";
				} catch (Exception exception) {
					System.out.println(exception.getMessage());
					return "fail";
				}
				System.out.println("변경된 패스워드: " + password);
			}
		}
		return "success";
	}
}
