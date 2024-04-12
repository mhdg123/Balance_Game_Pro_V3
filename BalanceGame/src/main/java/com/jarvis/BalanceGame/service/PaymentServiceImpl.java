package com.jarvis.BalanceGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dao.PaymentDAO;
import com.jarvis.BalanceGame.model.dto.PaymentDTO;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentDAO paymentDAO;
	
	@Override
	public boolean insert(PaymentDTO pDTO) {
		return paymentDAO.insert(pDTO);
	}

	@Override
	public PaymentDTO selectOne(PaymentDTO pDTO) {
		return paymentDAO.selectOne(pDTO);
	}

}
