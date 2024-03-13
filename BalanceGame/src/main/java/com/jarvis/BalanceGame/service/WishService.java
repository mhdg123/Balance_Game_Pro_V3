package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.WishDTO;

public interface WishService {
	public boolean insert(WishDTO wDTO);
	public boolean update(WishDTO wDTO);
	public boolean delete(WishDTO wDTO);
	public List<WishDTO> selectAll(WishDTO wDTO);
	public WishDTO selectOne(WishDTO wDTO);
}
