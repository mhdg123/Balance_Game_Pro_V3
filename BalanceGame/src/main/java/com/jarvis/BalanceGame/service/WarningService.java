package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.WarningDTO;

public interface WarningService {
	public List<WarningDTO> selectAll(WarningDTO wDTO);
	public boolean insert(WarningDTO wDTO);
	public boolean delete(WarningDTO wDTO);
	public WarningDTO selectOne(WarningDTO wDTO);
	
}
