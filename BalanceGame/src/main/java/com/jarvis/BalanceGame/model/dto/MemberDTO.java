package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class MemberDTO {
	  private String loginId; // 로그인 ID pk
	  private String memberPassword; // 비밀번호
	  private String name; // 이름
	  private String nickName;
	  private String cellPhone; // 전화번호
	  private String email; // 이메일
	  private String address; // 주소
	  private String gender; // 성별
	  @DateTimeFormat(pattern="yyyy-MM-dd")
	  private Date age; // 생년월일
	  private int coin; // 포인트
	  private int grade; // 등급
	  private String advertisementStatus; // 광고 상태(제거인지 아닌지) 
	  private String role; // 관리자 유무
	  private Date memberDate; // 유저 등록시간

	  //----------------------------------------------
	  private String searchCondition;
}
