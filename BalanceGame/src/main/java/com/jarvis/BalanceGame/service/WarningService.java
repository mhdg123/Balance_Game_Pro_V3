package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.WarningDTO;

public interface WarningService {
	public boolean insert();
	public boolean update();
	public boolean delete();
	public List<WarningDTO> selectAll();
	public WarningDTO selectOne();
}
