package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class LetterDTO {
	  @NotNull
	  private int letterId; // 쪽지 PK
	  @NotNull
	  private String sender; // 쪽지를 보내는 유저
	  @NotNull
	  private String loginId; // 쪽지받을 유저ID FK
	  @NotNull
	  private String title; // 제목
	  @NotNull
	  private String letterContents; // 쪽지내용
	  @NotNull
	  private String letterStatus; // 읽음 유무
	
	  private String letterType; // 신고인지 건의사항인지 
	  @NotNull
	  private Date letterDate; // 쪽지 보낸시간

	  //----------------------------------------
	  private String searchCondition;
	  private int cnt;
}
