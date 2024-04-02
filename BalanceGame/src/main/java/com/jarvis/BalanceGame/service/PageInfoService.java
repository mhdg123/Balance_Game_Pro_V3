package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.PageInfoDTO;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;

public interface PageInfoService {
	public List<QuestionDTO> selectAll(PageInfoDTO pDTO);
	
	public int calcTotalPages(PageInfoDTO pDTO);
	
	public int calculateOffset(PageInfoDTO pDTO);
}
