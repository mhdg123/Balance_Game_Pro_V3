package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.MemberDTO;

public interface MemberService {
	public boolean insert(MemberDTO mDTO);
	public boolean update(MemberDTO mDTO);
	public boolean delete(MemberDTO mDTO);
	public MemberDTO selectOne(MemberDTO mDTO);
}
