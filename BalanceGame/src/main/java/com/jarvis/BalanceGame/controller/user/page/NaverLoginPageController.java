
package com.jarvis.BalanceGame.controller.user.page;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class NaverLoginPageController {

	@Autowired
	MemberService memberService;
	
	@Value("${encrypted.clientId}")
	private String clientId;// 애플리케이션 클라이언트 아이디값";
	
	@Value("${encrypted.clientSecret}")
	private String clientSecret;// 애플리케이션 클라이언트 시크릿값";
	
	@GetMapping("/naverLogin")
	public String naverLoginPageController(MemberDTO mDTO,@RequestParam("code") String code,@RequestParam("state") String state,Model model,HttpSession session) throws UnsupportedEncodingException {

		
		// 토큰 저장 변수
		String access_token = "";
		String refresh_token = "";

		
		// 로그인 callback
		String LoginToken = LoginConnection(code,state);

		//토큰 데이터 추출
		JSONObject tokenJsonObj = new JSONObject(LoginToken); // code는 json형식을 가지고 있는 string타입
		access_token = tokenJsonObj.getString("access_token");
		refresh_token = tokenJsonObj.getString("refresh_token");

		System.out.println("억세스 토근 로그 : " + access_token);
		System.out.println("리프레쉬 토근 로그 : " + refresh_token);

		// 회원프로필 조회
		// access_token 네이버 로그인 접근 토큰;
		String header = "Bearer " + access_token; // Bearer 다음에 공백 추가

		String apiURL = "https://openapi.naver.com/v1/nid/me";

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Authorization", header);
		String responseBody = get(apiURL, requestHeaders);

		System.out.println(responseBody);

		//회원 정보 추출
		JSONObject userJsonObj = new JSONObject(responseBody); // code는 json형식을 가지고 있는 string타입
		JSONObject userProfileObj = userJsonObj.getJSONObject("response");
		System.out.println("response 추출 : "+userProfileObj);

		String nickname = (String) userProfileObj.getString("nickname");//닉네임 유니코드로 들어옴
		//profile_image : 네이버 유저 이미지 URL
		//age : 나이 범위 - 20-29
		String gender = userProfileObj.getString("gender");//성별 M,F 로 들어옴
		String email = userProfileObj.getString("email");//이메일
		String mobile = userProfileObj.getString("mobile");//전화번호
		//mobile_e164 : 국가 포함 - +821012345678
		String name = userProfileObj.getString("name");//이름 유니코드로 들어옴
		String birthday = userProfileObj.getString("birthday");//월 일 - 10-01
		String birthyear = userProfileObj.getString("birthyear");//년 - 1999
		// birthday + birthyear 로 저장하기
		
		System.out.println("닉네임 : "+nickname);
		System.out.println("성별 : "+gender);
		System.out.println("이메일 : "+email);
		System.out.println("전화번호 : "+mobile);
		System.out.println("이름 : "+name);
		System.out.println("생년월일 : "+birthyear+"-"+birthday);
		
		//회원 등록 여부 확인 - 전화번호로 확인
		//mDTO.setSearchCondition("전화번호회원조회");
		//mDTO.setEmail(email);
		//mDTO = memberService.selectOne(mDTO);
		String loginId="";
		int atIndex = email.indexOf('@');
		if (atIndex != -1) {
			loginId = email.substring(0, atIndex);
		}
		mDTO.setSearchCondition("socialLogin");
		mDTO.setLoginId(loginId);
		MemberDTO memberData = memberService.selectOne(mDTO);
		
		//회원가입 페이지 이동
		if(memberData == null) {
			mDTO.setName(name);
			mDTO.setNickName(nickname);
			mDTO.setGender(gender);
			mDTO.setEmail(email);
			mDTO.setCellPhone(mobile);
			mDTO.setAge(birthyear+"-"+birthday);
			model.addAttribute("memberData", mDTO);
			model.addAttribute("status", "socialJoin");
			return "user/join";
		}
		
		// 로그인 성공
		session.setAttribute("loginId", mDTO.getLoginId());
		model.addAttribute("status", "success");
		model.addAttribute("msg", mDTO.getLoginId() + "님 로그인 하셨습니다.");
		model.addAttribute("redirect", "/");
		return "alert";
	}

	//로그인 후 토큰 반환 메서드
	private String LoginConnection(String code,String state) throws UnsupportedEncodingException {

		//String code = request.getParameter("code");
		//String state = request.getParameter("state");
		String redirectURI = URLEncoder.encode("http://localhost:8088/naverLogin", "UTF-8");
		String apiURL;
		apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		apiURL += "client_id=" + clientId;
		apiURL += "&client_secret=" + clientSecret;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&code=" + code;
		apiURL += "&state=" + state;

		StringBuffer res = new StringBuffer();
		System.out.println("apiURL=" + apiURL);
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.println("responseCode=" + responseCode);
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;

			while ((inputLine = br.readLine()) != null) {
				System.out.println("가져오는 데이터 : " + inputLine);
				res.append(inputLine);
			}
			br.close();
			if (responseCode == 200) {
				System.out.println(res.toString());
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return res.toString();
	}

	//유저 정보 조회 메서드
	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 에러 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	//URL 유효성 확인 메서드
	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	//유저 정보 생성 메서드
	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
		}
	}
	
	
	//유저 정보 추출 메서드
	

}
