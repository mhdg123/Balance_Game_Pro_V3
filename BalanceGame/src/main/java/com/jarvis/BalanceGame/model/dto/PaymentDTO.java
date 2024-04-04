package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentDTO {
	  @NotNull
	  private int paymentId; // PK
	  @NotNull
	  private String loginId; // 로그인 FK
	  private int amount; // 결제금액
	  @NotNull
	  private Date paymentDate; // 결제 시간
	  
	  //---------------------------------------
	  private String searchCondition;
	  private int totalAmount; // 총 결제금액 
	  private int cnt;
}
