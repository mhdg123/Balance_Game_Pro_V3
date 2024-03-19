package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class AnswerDTO {
	@NotNull
	private int answerId; // 답변 ID
	@NotNull
    private int questionId; // 질문 FK
    private String loginId; // 로그인 FK
    @NotNull
    private String answer; // 선택한 답변
    @NotNull
    private Date answerDate; //답변 등록시간
    
    // java
    private String searchCondition;
}
