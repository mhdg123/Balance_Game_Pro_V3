package com.jarvis.BalanceGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dao.MemberItemDAO;
import com.jarvis.BalanceGame.model.dto.MemberItemDTO;

@Service
public class MemberItemServiceImpl implements MemberItemService{

	@Autowired
	private MemberItemDAO memberItemDAO;

	@Override
	public List<MemberItemDTO> selectAll(MemberItemDTO miDTO) {
		return memberItemDAO.selectAll(miDTO);
	}

	@Override
	public MemberItemDTO selectOne(MemberItemDTO miDTO) {
		return memberItemDAO.selectOne(miDTO);
	}
	
	@Override
	public boolean insert(MemberItemDTO miDTO) {
		return memberItemDAO.insert(miDTO);
	}
	
	@Override
	public boolean update(MemberItemDTO miDTO) {
		return memberItemDAO.update(miDTO);
	}

}
