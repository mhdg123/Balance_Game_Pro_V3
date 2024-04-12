package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.ItemDTO;

public interface ItemService {
	public List<ItemDTO> selectAll(ItemDTO iDTO);
	public ItemDTO selectOne(ItemDTO iDTO);
	public boolean insert(ItemDTO iDTO);
	public boolean update(ItemDTO iDTO);
	public boolean delete(ItemDTO iDTO);
}
