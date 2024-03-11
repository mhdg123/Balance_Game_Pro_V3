package com.jarvis.BalanceGame.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class WishDTO {
	 private int wishId; // 찜 ID
	 private int questionId; // 찜한 질문 ID
	 private String loginId; // 찜한 사용자의 로그인 ID
}
