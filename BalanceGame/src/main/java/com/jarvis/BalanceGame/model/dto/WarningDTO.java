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
	 @NotNull
	 private int warningId; // 신고 PK
	 @NotNull
	 private String loginId; // 신고당한 ID FK
	 @NotNull
	 private int commentId; // 신고당한 댓글ID FK
	 @NotNull
	 private Date warningDate; // 댓글 신고시간
}
