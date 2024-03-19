package com.jarvis.BalanceGame.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class WishDTO {
	 @NotNull
	 private int wishId; // 찜 ID
	 @NotNull
	 private int questionId; // 찜한 질문 ID
	 @NotNull
	 private String loginId; // 찜한 사용자의 로그인 ID
	 
	 //---------------------------------------------
	 private String questionTitle; // 찜한 질문 제목
}
