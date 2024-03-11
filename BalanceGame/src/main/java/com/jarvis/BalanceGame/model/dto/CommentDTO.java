package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class CommentDTO {
	private int commentId; // 댓글 ID
	private int questionId; // 질문 FK
	private String loginId; // 로그인 FK
	private String comments; // 댓글
	private Date commentDate; // 댓글 등록시간
}
