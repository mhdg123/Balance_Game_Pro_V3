package com.jarvis.BalanceGame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dao.WarningDAO;
import com.jarvis.BalanceGame.model.dto.WarningDTO;

@Service
public class WarningServiceImpl implements WarningService{

	@Autowired
	private WarningDAO warningDAO;
	
	@Override
	public boolean insert(WarningDTO wDTO) {
		return warningDAO.insert(wDTO);
	}

	@Override
	public boolean delete(WarningDTO wDTO) {
		return warningDAO.delete(wDTO);
	}

}
