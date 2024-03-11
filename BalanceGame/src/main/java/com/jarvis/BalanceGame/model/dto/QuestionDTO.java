package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QuestionDTO {
    private int question_id; // 질문 ID
    private String login_id; // 작성자 ID
    private String title; // 제목
    private String answer_A; // 답변 A
    private String answer_A_img; // 답변 A 이미지 
    private String answer_B; // 답변 B
    private String answer_B_img; // 답변 B 이미지
    private String explanation; // 문제 설명
    private String question_access; // 문제 승인여부
    private Date question_date; // 질문 등록시간
}
