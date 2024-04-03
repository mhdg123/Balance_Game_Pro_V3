package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class CommentDTO {
	@NotNull
	private int commentId; // 댓글 ID
	@NotNull
	private int questionId; // 질문 FK
	@NotNull
	private String loginId; // 로그인 FK
	@NotNull
	@NotEmpty
	private String comments; // 댓글
	@NotNull
	private Date commentDate; // 댓글 등록시간
	
	//------------------------------
	private String searchCondition;
	private int memberGrade;
	private int cnt;
}
