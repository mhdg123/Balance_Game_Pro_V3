package com.jarvis.BalanceGame.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberItemDTO {
	 private int member_item_id; // 아이템 ID
	 private String login_id; // 아이템을 구매한 회원의 로그인 ID
	 private int item_id; // 아이템 ID
	 private int member_item_count; // 구매한 아이템 개수
}
