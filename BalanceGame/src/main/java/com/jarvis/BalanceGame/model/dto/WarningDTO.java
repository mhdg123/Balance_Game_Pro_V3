package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WarningDTO {
	 private int warningId; // 신고 PK
	 private String loginId; // 신고당한 ID FK
	 private int commentId; // 신고당한 댓글ID FK
	 private Date warningDate; // 댓글 신고시간
}
