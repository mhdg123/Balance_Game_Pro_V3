package com.jarvis.BalanceGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dao.MemberDAO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public boolean insert(MemberDTO mDTO) {
		return memberDAO.insert(mDTO);
	}

	@Override
	public boolean update(MemberDTO mDTO) {
		return memberDAO.update(mDTO);
	}

	@Override
	public boolean delete(MemberDTO mDTO) {
		return memberDAO.delete(mDTO);
	}

	@Override
	public List<MemberDTO> selectAll(MemberDTO mDTO) {
		return memberDAO.selectAll(mDTO);
	}

	@Override
	public MemberDTO selectOne(MemberDTO mDTO) {
		return memberDAO.selectOne(mDTO);
	}

}
