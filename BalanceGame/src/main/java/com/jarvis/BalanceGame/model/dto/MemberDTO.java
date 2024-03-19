package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import org.jetbrains.annotations.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class MemberDTO {
	  @NotBlank
	  private String loginId; // 로그인 ID pk
	  @NotBlank
	  private String memberPassword; // 비밀번호
	  @NotBlank
	  private String name; // 이름
	  @NotBlank
	  private String nickName;
	  @NotNull
	  private String cellPhone; // 전화번호
	  @NotNull
	  private String email; // 이메일
	  @NotNull
	  private String address; // 주소
	  @NotNull
	  private String gender; // 성별
	  @DateTimeFormat(pattern="yyyy-MM-dd")
	  @NotNull
	  private String age; // 생년월일
	  private int coin; // 포인트
	  private int grade; // 등급
	  private String advertisementStatus; // 광고 상태(제거인지 아닌지)
	  @NotNull
	  private String role; // 관리자 유무
	  @NotNull
	  private Date memberDate; // 유저 등록시간

	  //----------------------------------------------
	  private String searchCondition;
	  private int memberCount; // 회원 수 
	  private int total; // 구매 총금액 
	  private int ranking; // 구매 등수
}
