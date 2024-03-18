package com.jarvis.BalanceGame.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class ItemDTO {
	  private int itemId; // 아이템 PK
	  private String itemName; // 아이템 이름
	  private int itemPrice; // 아이템 가격 
	  private String itemImg; // 아이템 이미지
	  private String itemType; // 아이템 타입(아이템 / 포인트)
}
