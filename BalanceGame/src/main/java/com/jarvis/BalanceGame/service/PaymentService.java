package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.PaymentDTO;

public interface PaymentService {
	public boolean insert(PaymentDTO pDTO);
	public boolean update(PaymentDTO pDTO);
	public boolean delete(PaymentDTO pDTO);
	public List<PaymentDTO> selectAll(PaymentDTO pDTO);
	public PaymentDTO selectOne(PaymentDTO pDTO);
}
