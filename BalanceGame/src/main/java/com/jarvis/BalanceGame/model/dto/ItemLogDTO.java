package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class ItemLogDTO {
	 @NotNull
	 private int itemLogId; // PK
	 @NotNull
	 private int itemId; //  아이템 ID FK
	 private int itemLogCount; // SELECT할 때 필요한 아이템 개수  
	 @NotNull
	 private Date itemLogDate; // 아이템 구매한 시간 
//------------------------------------------------------------
	 private int totalCount; // 총 사용한 아이템 개수 
	 private String itemName;
}
