package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.PageInfoDTO;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;

public interface PageInfoService {
	public List<QuestionDTO> selectAll(PageInfoDTO pDTO);
	
	// 토탈 페이지 계산
	public int calcTotalPages(PageInfoDTO pDTO);
	
	// 페이지 번호에 따른 offset 계산
	public int calculateOffset(PageInfoDTO pDTO);
}
