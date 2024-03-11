package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class CommentDTO {
	private int comment_id; // 댓글 ID
	private int question_id; // 질문 FK
	private String login_id; // 로그인 FK
	private String comments; // 댓글
	private Date comment_date; // 댓글 등록시간
}
