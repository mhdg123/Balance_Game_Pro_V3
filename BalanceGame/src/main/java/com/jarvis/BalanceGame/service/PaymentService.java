package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.PaymentDTO;

public interface PaymentService {
	public boolean insert();
	public boolean update();
	public boolean delete();
	public List<PaymentDTO> selectAll();
	public PaymentDTO selectOne();
}
