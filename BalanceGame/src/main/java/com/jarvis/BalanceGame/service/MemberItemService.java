package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.MemberItemDTO;

public interface MemberItemService {
	public boolean insert();
	public boolean update();
	public boolean delete();
	public List<MemberItemDTO> selectAll();
	public MemberItemDTO selectOne();
}
