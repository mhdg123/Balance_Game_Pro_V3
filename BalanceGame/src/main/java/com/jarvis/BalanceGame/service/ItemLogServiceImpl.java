package com.jarvis.BalanceGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dao.ItemLogDAO;
import com.jarvis.BalanceGame.model.dto.ItemLogDTO;

@Service
public class ItemLogServiceImpl implements ItemLogService{

	@Autowired
	private ItemLogDAO itemLogDAO;
	
	@Override
	public boolean insert(ItemLogDTO iDTO) {
		return itemLogDAO.insert(iDTO);
	}

	@Override
	public List<ItemLogDTO> selectAll(ItemLogDTO iDTO) {
		return itemLogDAO.selectAll(iDTO);
	}

}
