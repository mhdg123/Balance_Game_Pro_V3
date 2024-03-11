package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;

public interface QuestionService {
	public boolean insert();
	public boolean update();
	public boolean delete();
	public List<QuestionDTO> selectAll();
	public QuestionDTO selectOne();
}
