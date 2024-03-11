package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class LetterDTO {
	  private int letter_id; // 쪽지 PK
	  private String login_id; // 쪽지받을 유저ID FK
	  private String title; // 제목
	  private String letter_contents; // 쪽지내용
	  private String letter_status; // 읽음 유무
	  private Date letter_date; // 쪽지 보낸시간

}
