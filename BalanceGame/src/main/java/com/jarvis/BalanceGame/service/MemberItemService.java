package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.MemberItemDTO;

public interface MemberItemService {
	public List<MemberItemDTO> selectAll(MemberItemDTO miDTO);
	public MemberItemDTO selectOne(MemberItemDTO miDTO);
	public boolean insert(MemberItemDTO miDTO);
	public boolean update(MemberItemDTO miDTO);
}
