package com.jarvis.BalanceGame.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberItemDTO {
	 private int memberItemId; // 아이템 ID
	 private String loginId; // 아이템을 구매한 회원의 로그인 ID
	 private int itemId; // 아이템 ID
	 private int memberItemCount; // 구매한 아이템 개수
}
