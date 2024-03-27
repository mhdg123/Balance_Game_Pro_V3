package com.jarvis.BalanceGame.controller.user.action;

import java.lang.reflect.Member;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.tags.form.AbstractFormTag;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.google.gson.Gson;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;
import retrofit2.http.POST;

@Controller
@RequestMapping("/user")
public class KaKaoLoginController {

	@Autowired
	private MemberService memberService;

	@PostMapping("/kakao")
	public @ResponseBody String kakaoData(MemberDTO mDTO, @RequestParam("year") String year,
			@RequestParam("monthDay") String monthDay, Gson gson, HttpSession session, Map<String, String> map) {
		System.out.println("카카오 로그인 비동기 실행");
		// 로그인 아이디(이메일 기준으로 앞에 글자들 자르기)
		String loginId = mDTO.getLoginId();
		String name = mDTO.getName();
		int atIndex = loginId.indexOf('@');
		if (atIndex != -1) {
			loginId = loginId.substring(0, atIndex);
		}
		System.out.println("카카오 로그인 아이디 : " + loginId);

		// 닉네임
		String nickName = mDTO.getNickName();
		System.out.println("카카오 로그인 닉네임 : " + nickName);

		// 패스워드 (로그인 아이디로 인코딩하여 임의 패스워드 생성)
		String password = loginId; // 로그인 아이디로 인코딩하여 임의 패스워드 생성
		byte[] targetBytes = password.getBytes();
		Encoder encoder = Base64.getEncoder();
		byte[] encodedBytes = encoder.encode(targetBytes);
		password = new String(encodedBytes);
		System.out.println("카카오 로그인 암호화 패스워드 : " + password);

		// 이름 (조지훈 )
		System.out.println("카카오 로그인 이름 : " + mDTO.getName());

		// 폰번호
		String cellPhon = mDTO.getCellPhone();
		cellPhon = cellPhon.replaceAll("[^0-9]", ""); // 숫자만 남기기
		cellPhon = "01" + cellPhon.substring(3);
		System.out.println("카카오 로그인 폰번호 : " + cellPhon);

		// 이메일 (whwlgns42@kakao.com 으로 들어옴)
		String email = mDTO.getEmail();
		System.out.println("카카오 로그인 이메일 : " + mDTO.getEmail());
		// 주소(null)

		// 성별 (male)
		String gender = mDTO.getGender();
		if (gender.equals("male")) {
			mDTO.setGender("M");
		} else {
			mDTO.setGender("F");
		}
		gender = mDTO.getGender();

		System.out.println("카카오 로그인 성별 : " + mDTO.getGender());
		// 생년월일
		String birthYear = year;
		String birthDay = monthDay;

		String age = formatBirthDate(birthYear, birthDay);
		System.out.println("카카오 로그인 나이 : " + age);
		mDTO.setLoginId(loginId);
		mDTO.setMemberPassword(password);
		mDTO.setName(name);
		mDTO.setNickName(nickName);
		mDTO.setGender(gender);
		mDTO.setEmail(email);
		mDTO.setCellPhone(cellPhon);
		mDTO.setAge(age);

		System.out.println("파싱 데이터 " + mDTO); // 파싱 데이터

		mDTO.setSearchCondition("socialLogin");
		MemberDTO memberData = memberService.selectOne(mDTO);
//		System.out.println("조회된 아이디 코인 값 : " + memberData.getCoin() );
//		System.out.println("조회된 아이디 객체 : " + memberData);
//		memberData.setLoginId("test");
		System.out.println("로그인시 조회된 데이터" + memberData );
		// 회원 조회해서 회원이면 데이터 설정
		if (memberData == null) { // 카카오로 로그인시 조회된 데이터가 없으면 카카오데이터 파싱한 데이터로 데이터 넘겨주기
			System.out.println("회원가입");
			mDTO.setSearchCondition("join");
			return gson.toJson(mDTO);
			// 비회원이면
		} else {
			memberData.setSearchCondition("login"); // kakaoLogin.js확인 // 카카오 로그인시 데이터가 있으면 sc에 login으로 분기 처리
		}
		return gson.toJson(memberData); // 카카오 로그인 데이터 파싱후 데이터 비동기 응답

	}

	@PostMapping("/login/kakao")
	public String kakaoLogin(MemberDTO mDTO, HttpSession session, Model model) {
		// 회원일때
		System.out.println("카카오로 로그인 함!!");
		System.out.println("로그인 시 세션에 저장 될 아이디 : " + mDTO.getLoginId());
		System.out.println("로그인 시 세션에 저장 될 포인트 : " + mDTO.getCoin());
		System.out.println("로그인 시 세션에 저장 될 닉네임 : " + mDTO.getNickName());
		session.setAttribute("loginId", mDTO.getLoginId());
		session.setAttribute("coin", mDTO.getCoin());
		session.setAttribute("nickName", mDTO.getNickName());
		model.addAttribute("status", "success");
		model.addAttribute("msg", mDTO.getLoginId() + "님 로그인 하셨습니다.");
		model.addAttribute("redirect", "/");
		return "alert"; // 메인페이지
	}

	// 생년월일 데이터 파싱
	public static String formatBirthDate(String year, String day) {
		// 생년월일을 합쳐서 하나의 문자열로 만듭니다.
		String birthDate = year + day;

		try {
			// yyyyMMdd 형식으로 파싱하여 Date 객체로 변환합니다.
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMdd");
			Date date = inputFormat.parse(birthDate);

			// yyyyMMdd 형식으로 다시 변환합니다.
			SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
			return outputFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
