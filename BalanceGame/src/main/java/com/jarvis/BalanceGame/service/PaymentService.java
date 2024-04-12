package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.PaymentDTO;

public interface PaymentService {
	public PaymentDTO selectOne(PaymentDTO pDTO);
	public boolean insert(PaymentDTO pDTO);
}
