package com.jarvis.BalanceGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dao.AnswerDAO;
import com.jarvis.BalanceGame.model.dto.AnswerDTO;

@Service("answerService")
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	private AnswerDAO answerDAO;
	
	@Override
	public boolean insert(AnswerDTO aDTO) {
		return answerDAO.insert(aDTO);
	}

	@Override
	public boolean update(AnswerDTO aDTO) {
		return answerDAO.update(aDTO);
	}

//	@Override
//	public boolean delete(AnswerDTO aDTO) {
//		return false;
//	}

}
