package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class ItemLogDTO {
	 private int item_log_id; // PK
	 private int item_id; // -- 아이템 ID FK
	 private int Item_log_count; // SELECT할 때 필요한 아이템 개수  
	 private Date item_log_date; // 아이템 구매한 시간 

}
