package com.jarvis.BalanceGame.service;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dto.MemberDTO;


@Service
public class NaverLoginServiceImpl implements NaverLoginService{


    @Value("${encrypted.clientId}")
    private String clientId;
    
    @Value("${encrypted.clientSecret}")
    private String clientSecret;
	
	@Override
	public String getToken(String code, String state) throws UnsupportedEncodingException {
        String redirectURI = URLEncoder.encode("http://localhost:8088/naverLogin", "UTF-8");
        String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
        apiURL += "client_id=" + clientId;
        apiURL += "&client_secret=" + clientSecret;
        apiURL += "&redirect_uri=" + redirectURI;
        apiURL += "&code=" + code;
        apiURL += "&state=" + state;

        return callNaverApi(apiURL);
	}

	@Override
	public String getUserProfile(String accessToken) {
        String header = "Bearer " + accessToken;
        String apiURL = "https://openapi.naver.com/v1/nid/me";

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Authorization", header);

        return callNaverApi(apiURL, requestHeaders);
	}

	@Override
	public MemberDTO processNaverLogin(String tokenJson, MemberDTO mDTO) {
		
		// 토큰 데이터 추출
		JSONObject tokenJsonObj = new JSONObject(tokenJson);// code는 json형식을 가지고 있는 string타입
        String access_token = tokenJsonObj.getString("access_token");
        
        // System.out.println("억세스 토근 로그 : " + access_token);
        
        //회원 정보 가져오기
        String userProfile = getUserProfile(access_token);
        
		// System.out.println("사용자 정보 : "+userProfile);

        
        // 회원 정보 추출
        JSONObject userJsonObj = new JSONObject(userProfile);// code는 json형식을 가지고 있는 string타입
        JSONObject userProfileObj = userJsonObj.getJSONObject("response");

        //System.out.println("response 추출 : " + userProfileObj);
        
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
		
		//System.out.println("닉네임 : "+nickname);
		//System.out.println("성별 : "+gender);
		//System.out.println("이메일 : "+email);
		//System.out.println("전화번호 : "+mobile);
		//System.out.println("이름 : "+name);
		//System.out.println("생년월일 : "+birthyear+"-"+birthday);
		
		
        int atIndex = email.indexOf('@');
        if (atIndex != -1) {
            String loginId = email.substring(0, atIndex);
            mDTO.setLoginId(loginId);
        }
        mDTO.setSearchCondition("socialLogin");
        mDTO.setName(name);
        mDTO.setNickName(nickname);
        mDTO.setGender(gender);
        mDTO.setEmail(email);
        mDTO.setCellPhone(mobile);
        mDTO.setAge(birthyear + "-" + birthday);

        return mDTO;
	}
	
	//유저 토큰 메서드
    private String callNaverApi(String apiUrl) {
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
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

	//유저 정보 조회 메서드
	private static String callNaverApi(String apiUrl, Map<String, String> requestHeaders) {
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
}
