package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.CommentDTO;

public interface CommentService {
	public boolean insert();
	public boolean update();
	public boolean delete();
	public List<CommentDTO> selectAll();
	public CommentDTO selectOne();
}
