package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.WishDTO;

public interface WishService {
	public boolean insert();
	public boolean update();
	public boolean delete();
	public List<WishDTO> selectAll();
	public WishDTO selectOne();
}
