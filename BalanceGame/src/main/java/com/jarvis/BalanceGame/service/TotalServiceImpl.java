package com.jarvis.BalanceGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dao.TotalDAO;
import com.jarvis.BalanceGame.model.dto.TotalDTO;

@Service
public class TotalServiceImpl implements TotalService{

	@Autowired
	private TotalDAO totalDAO;
	
	@Override
	public List<TotalDTO> selectAll(TotalDTO tDTO) {
		
		return totalDAO.selectAll(tDTO);
	}

}
