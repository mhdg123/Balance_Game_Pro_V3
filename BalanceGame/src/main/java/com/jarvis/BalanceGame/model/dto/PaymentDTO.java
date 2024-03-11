package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentDTO {
	  private int payment_id; // PK
	  private String login_id; // 로그인 FK
	  private int amount; // 결제금액
	  private Date payment_date; // 결제 시간
}
