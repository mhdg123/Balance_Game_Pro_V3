package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class MemberDTO {
	  private String login_id; // 로그인 ID pk
	  private String member_password; // 비밀번호
	  private String name; // 이름
	  private String cell_phone; // 전화번호
	  private String email; // 이메일
	  private String address; // 주소
	  private String gender; // 성별
	  private Date age; // 생년월일
	  private int coin; // 포인트
	  private int grade; // 등급
	  private int warning_count; // 경고 횟수
	  private String advertisement_status; // 광고 상태(제거인지 아닌지) 
	  private String role; // 관리자 유무
	  private Date member_date; // 유저 등록시간

}
