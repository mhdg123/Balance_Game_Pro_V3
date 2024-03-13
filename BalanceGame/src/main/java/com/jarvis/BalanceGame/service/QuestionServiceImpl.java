package com.jarvis.BalanceGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dao.QuestionDAO;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionDAO questionDAO; 
	
	@Override
	public boolean insert(QuestionDTO qDTO) {
		return questionDAO.insert(qDTO);
	}

	@Override
	public boolean update(QuestionDTO qDTO) {
		return questionDAO.update(qDTO);
	}

	@Override
	public boolean delete(QuestionDTO qDTO) {
		return questionDAO.delete(qDTO);
	}

	@Override
	public List<QuestionDTO> selectAll(QuestionDTO qDTO) {
		return questionDAO.selectAll(qDTO);
	}

	@Override
	public QuestionDTO selectOne(QuestionDTO qDTO) {
		return questionDAO.selectOne(qDTO);
	}

}
