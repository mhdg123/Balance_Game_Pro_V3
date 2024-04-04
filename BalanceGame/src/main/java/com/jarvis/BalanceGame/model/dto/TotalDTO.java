package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TotalDTO {
	  @NotNull
	  private int totalAmountID; // 총계 ID PK
	  private int totalAmount; // 총금액
	  private Date totalDate;
	  
	  //------------------------
	  private String year;
	  private int month;
	  private int day;
	  private String searchCondition;
	  
}
