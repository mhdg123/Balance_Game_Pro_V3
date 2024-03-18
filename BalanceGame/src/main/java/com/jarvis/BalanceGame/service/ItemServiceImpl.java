package com.jarvis.BalanceGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dao.ItemDAO;
import com.jarvis.BalanceGame.model.dto.ItemDTO;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemDAO itemDAO;
	
	@Override
	public boolean insert(ItemDTO iDTO) {
		return itemDAO.insert(iDTO);
	}

	@Override
	public boolean update(ItemDTO iDTO) {
		return itemDAO.update(iDTO);
	}

	@Override
	public boolean delete(ItemDTO iDTO) {
		return itemDAO.delete(iDTO);
	}

	@Override
	public List<ItemDTO> selectAll(ItemDTO iDTO) {
		return itemDAO.selectAll(iDTO);
	}

	@Override
	public ItemDTO selectOne(ItemDTO iDTO) {
		return itemDAO.selectOne(iDTO);
	}

}
