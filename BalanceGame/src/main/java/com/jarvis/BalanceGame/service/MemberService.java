package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.MemberDTO;

public interface MemberService {
	public boolean insert();
	public boolean update();
	public boolean delete();
	public List<MemberDTO> selectAll();
	public MemberDTO selectOne();
}
