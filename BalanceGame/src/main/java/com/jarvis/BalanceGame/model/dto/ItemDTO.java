package com.jarvis.BalanceGame.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class ItemDTO {
	  private int item_id; // 아이템 PK
	  private String item_name; // 아이템 이름
	  private int item_price; // 아이템 가격 
}
