package com.jarvis.BalanceGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jarvis.BalanceGame.model.dao.CommentDAO;
import com.jarvis.BalanceGame.model.dto.CommentDTO;

public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDAO commentDAO;
	
	@Override
	public boolean insert(CommentDTO cDTO) {
		return commentDAO.insert(cDTO);
	}

	@Override
	public boolean update(CommentDTO cDTO) {
		return false;
	}

	@Override
	public boolean delete(CommentDTO cDTO) {
		return false;
	}

	@Override
	public List<CommentDTO> selectAll(CommentDTO cDTO) {
		return commentDAO.selectAll(cDTO);
	}
}
