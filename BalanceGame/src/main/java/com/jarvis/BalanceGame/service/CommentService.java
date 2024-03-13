package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.CommentDTO;

public interface CommentService {
	public boolean insert(CommentDTO cDTO);
	public boolean update(CommentDTO cDTO);
	public boolean delete(CommentDTO cDTO);
	public List<CommentDTO> selectAll(CommentDTO cDTO);
}
