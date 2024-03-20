package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.ItemLogDTO;

public interface ItemLogService {
	public boolean insert(ItemLogDTO iDTO);
	public List<ItemLogDTO> selectAll(ItemLogDTO iDTO);
}
