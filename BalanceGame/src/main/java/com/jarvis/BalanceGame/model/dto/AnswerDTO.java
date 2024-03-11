package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class AnswerDTO {
	private int answer_id; // 답변 ID
    private int question_id; // 질문 FK
    private String login_id; // 로그인 FK
    private String answer; // 선택한 답변
    private Date answer_date; //답변 등록시간
}
