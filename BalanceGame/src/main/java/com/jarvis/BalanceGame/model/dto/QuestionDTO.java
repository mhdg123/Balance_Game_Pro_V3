package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QuestionDTO {
	@NotNull
    private int questionId; // 질문 ID
	@NotNull
    private String writer; // 작성자 ID
	@NotNull
    private String title; // 제목
    private String answerA; // 답변 A
    private String answerAImg; // 답변 A 이미지 
    private String answerB; // 답변 B
    private String answerBImg; // 답변 B 이미지
    private String explanation; // 문제 설명
    @NotNull
    private String questionAccess; // 문제 승인여부
    @NotNull
    private Date questionDate; // 질문 등록시간
    
    //---------------------------------------
    private String searchCondition;
    private int wishId;
    private int answerACount;
    private int answerBCount;
    private int likeCount;
    private int questionCount;
}
