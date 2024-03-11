package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.ItemLogDTO;

public interface ItemLogService {
	public boolean insert();
	public boolean update();
	public boolean delete();
	public List<ItemLogDTO> selectAll();
	public ItemLogDTO selectOne();
}
