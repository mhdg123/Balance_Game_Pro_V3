package com.jarvis.BalanceGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dao.WishDAO;
import com.jarvis.BalanceGame.model.dto.WishDTO;

@Service("wishService")
public class WishServiceImpl implements WishService{

	@Autowired
	private WishDAO wishDAO;
	
	@Override
	public boolean insert(WishDTO wDTO) {
		return wishDAO.insert(wDTO);
	}

	@Override
	public boolean delete(WishDTO wDTO) {
		return wishDAO.delete(wDTO);
	}

	@Override
	public List<WishDTO> selectAll(WishDTO wDTO) {
		return wishDAO.selectAll(wDTO);
	}

	@Override
	public WishDTO selectOne(WishDTO wDTO) {
		return wishDAO.selectOne(wDTO);
	}

}
