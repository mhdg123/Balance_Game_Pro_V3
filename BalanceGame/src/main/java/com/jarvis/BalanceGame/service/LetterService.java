package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.LetterDTO;

public interface LetterService {
	public boolean insert();
	public boolean update();
	public boolean delete();
	public List<LetterDTO> selectAll();
	public LetterDTO selectOne();
}
