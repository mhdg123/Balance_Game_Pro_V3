package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WarningDTO {
	 private int warningId; // 신고 PK
	 private String repoter; // 신고한사람 
	 private String commentWriter; // 신고당한 ID FK
	 private int commentId; // 신고당한 댓글ID FK
	 private Date warningDate; // 댓글 신고시간
}
