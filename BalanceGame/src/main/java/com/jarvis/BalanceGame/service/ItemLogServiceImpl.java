package com.jarvis.BalanceGame.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dao.IItemLogDAO;
import com.jarvis.BalanceGame.model.dto.ItemLogDTO;

@Service("itemLogService")
public class ItemLogServiceImpl implements ItemLogService{

	@Autowired
	private IItemLogDAO itemLogDAO;

	@Override
	public List<ItemLogDTO> selectAll(ItemLogDTO iDTO) {
		return itemLogDAO.selectAll();
	}
	
	@Override
	public boolean insert(ItemLogDTO iDTO) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("itemId", iDTO.getItemId());
		map.put("itemLogCount", iDTO.getItemLogId());
		if(itemLogDAO.insert(map) >=1 ) {
			return true;
		}
		return false;
	}
}
