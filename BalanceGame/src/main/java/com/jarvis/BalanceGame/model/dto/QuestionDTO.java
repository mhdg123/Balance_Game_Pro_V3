package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QuestionDTO {
    private int questionId; // 질문 ID
    private String writer; // 작성자 ID
    private String title; // 제목
    private String answerA; // 답변 A
    private String answerAImg; // 답변 A 이미지 
    private String answerB; // 답변 B
    private String answerBImg; // 답변 B 이미지
    private String explanation; // 문제 설명
    private String questionAccess; // 문제 승인여부
    private Date questionDate; // 질문 등록시간
    
    //---------------------------------------
    private String searchCondition;
    private int questionLikeID;
    private int answerACount;
    private int answerBCount;
    private int likeCount;
}
