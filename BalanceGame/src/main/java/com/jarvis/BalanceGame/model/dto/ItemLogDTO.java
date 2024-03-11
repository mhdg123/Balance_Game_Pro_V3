package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class ItemLogDTO {
	 private int itemLogId; // PK
	 private int itemId; // -- 아이템 ID FK
	 private int ItemLogCount; // SELECT할 때 필요한 아이템 개수  
	 private Date itemLogDate; // 아이템 구매한 시간 

}
