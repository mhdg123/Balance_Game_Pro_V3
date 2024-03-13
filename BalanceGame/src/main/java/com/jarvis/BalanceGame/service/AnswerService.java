package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.AnswerDTO;

public interface AnswerService {
	public boolean insert(AnswerDTO aDTO);
	public boolean update(AnswerDTO aDTO);
	//public boolean delete(AnswerDTO aDTO);
}
