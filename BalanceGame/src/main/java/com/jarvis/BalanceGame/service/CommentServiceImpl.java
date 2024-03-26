package com.jarvis.BalanceGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dao.CommentDAO;
import com.jarvis.BalanceGame.model.dto.CommentDTO;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDAO commentDAO;
	
	@Override
	public boolean insert(CommentDTO cDTO) {
		return commentDAO.insert(cDTO);
	}

	@Override
	public boolean update(CommentDTO cDTO) {
		return commentDAO.update(cDTO);
	}

	@Override
	public boolean delete(CommentDTO cDTO) {
		return commentDAO.delete(cDTO);
	}

	@Override
	public List<CommentDTO> selectAll(CommentDTO cDTO) {
		return commentDAO.selectAll(cDTO);
	}
}
