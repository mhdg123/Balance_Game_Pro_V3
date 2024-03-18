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
	public boolean update(PaymentDTO pDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(PaymentDTO pDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PaymentDTO> selectAll(PaymentDTO pDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentDTO selectOne(PaymentDTO pDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
