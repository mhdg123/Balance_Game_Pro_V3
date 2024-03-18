package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class PaymentDTO {
	  private int paymentId; // PK
	  private String loginId; // 로그인 FK
	  private int amount; // 결제금액
	  private Date paymentDate; // 결제 시간
	  
	  //---------------------------------------
	  private String searchCondition;
}
