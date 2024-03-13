package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;

public interface QuestionService {
	public boolean insert(QuestionDTO qDTO);
	public boolean update(QuestionDTO qDTO);
	public boolean delete(QuestionDTO qDTO);
	public List<QuestionDTO> selectAll(QuestionDTO qDTO);
	public QuestionDTO selectOne(QuestionDTO qDTO);
}
