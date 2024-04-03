package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.TotalDTO;

public interface TotalService {
	public List<TotalDTO> selectAll(TotalDTO tDTO);
}
