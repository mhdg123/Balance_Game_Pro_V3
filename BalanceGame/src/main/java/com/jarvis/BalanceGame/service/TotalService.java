package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.TotalDTO;

public interface TotalService {
	public boolean insert();
	public boolean update();
	public boolean delete();
	public List<TotalDTO> selectAll();
	public TotalDTO selectOne();
}
