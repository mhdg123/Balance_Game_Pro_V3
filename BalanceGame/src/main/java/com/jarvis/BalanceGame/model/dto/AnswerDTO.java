package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class AnswerDTO {
	private int answerId; // 답변 ID
    private int questionId; // 질문 FK
    private String loginId; // 로그인 FK
    private String answer; // 선택한 답변
    private Date answerDate; //답변 등록시간
    
    // java
    private String searchCondition;
}
