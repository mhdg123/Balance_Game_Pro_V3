package com.jarvis.BalanceGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dao.LetterDAO;
import com.jarvis.BalanceGame.model.dto.LetterDTO;

@Service
public class LetterServiceImpl implements LetterService{

	@Autowired
	private LetterDAO letterDAO;
	
	
	@Override
	public boolean insert(LetterDTO lDTO) {
		return letterDAO.insert(lDTO);
	}

	@Override
	public boolean update(LetterDTO lDTO) {
		return letterDAO.update(lDTO);
	}

	@Override
	public boolean delete(LetterDTO lDTO) {
		return letterDAO.delete(lDTO);
	}

	@Override
	public LetterDTO selectOne(LetterDTO lDTO) {
		return letterDAO.selectOne(lDTO);
	}

	@Override
	public List<LetterDTO> selectAll(LetterDTO lDTO) {
		// TODO Auto-generated method stub
		return letterDAO.selectAll(lDTO);
	}
}
