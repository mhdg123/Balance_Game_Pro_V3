package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.WarningDTO;

public interface WarningService {
	public boolean insert(WarningDTO wDTO);
	public boolean delete(WarningDTO wDTO);
}
