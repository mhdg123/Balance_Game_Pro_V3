package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.LetterDTO;

public interface LetterService {
	public boolean insert(LetterDTO lDTO);
	public boolean update(LetterDTO lDTO);
	public boolean delete(LetterDTO lDTO);
	public LetterDTO selectOne(LetterDTO lDTO);
	public List<LetterDTO>selectAll(LetterDTO lDTO);
}
