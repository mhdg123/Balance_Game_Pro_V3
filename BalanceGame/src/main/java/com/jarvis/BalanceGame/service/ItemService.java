package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.ItemDTO;

public interface ItemService {
	public boolean insert();
	public boolean update();
	public boolean delete();
	public List<ItemDTO> selectAll();
	public ItemDTO selectOne();
}
