package com.jarvis.BalanceGame.model.dto;

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
}
