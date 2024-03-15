package com.jarvis.BalanceGame.controller.admin.async;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.service.LetterService;

public class IdSearchAsync {
//
//	@Autowired
//	private LetterService letterService;
//	
//	@RequestMapping("/idSearchAsync")
//	public @ResponseBody String idSearchAsync(LetterDTO lDTO, Gson gson) {
//		
//		lDTO.setSearchCondition("아이디조회");
//		
//		List<LetterDTO> lDatas = letterService.selectAll(lDTO);
//		
//		if (lDatas != null) {
//			System.out.println(lDatas);
//			System.out.println("건의사항 데이터 있음"); // 조지훈
//			String jsonData = gson.toJson(lDatas);
//			return gson.toJson(lDatas);
//		}
//		else {
//			System.out.println("건의사항 데이터 없음"); // 조지훈
//			String jsonData = gson.toJson(lDatas);
//			return gson.toJson(lDatas);
//		}
//		
//	}
	
}
