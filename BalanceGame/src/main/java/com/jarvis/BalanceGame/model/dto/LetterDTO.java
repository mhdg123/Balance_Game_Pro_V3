package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class LetterDTO {
	  private int letterId; // 쪽지 PK
	  private String sender; // 쪽지를 보내는 유저 
	  private String loginId; // 쪽지받을 유저ID FK
	  private String title; // 제목
	  private String letterContents; // 쪽지내용
	  private String letterStatus; // 읽음 유무
	  private Date letterDate; // 쪽지 보낸시간

	  //----------------------------------------
	  private String searchCondition;
}
