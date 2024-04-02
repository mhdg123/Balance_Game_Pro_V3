package com.jarvis.BalanceGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dao.PageInfoDAO;
import com.jarvis.BalanceGame.model.dto.PageInfoDTO;

@Service
public class PageInfoServiceImpl implements PageInfoService{

	@Autowired
	private PageInfoDAO pageInfoDAO;
	
	@Override
	public List<PageInfoDTO> selectAll(PageInfoDTO pDTO) {
		return pageInfoDAO.selectAll(pDTO);
	}

	@Override
	public int calcTotalPages(PageInfoDTO pDTO) {
		return pageInfoDAO.calcTotalPages(pDTO);
	}

	@Override
	public int calculateOffset(PageInfoDTO pDTO) {
		return pageInfoDAO.calculateOffset(pDTO);
	}

}
