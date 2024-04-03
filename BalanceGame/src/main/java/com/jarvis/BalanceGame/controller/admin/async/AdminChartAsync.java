package com.jarvis.BalanceGame.controller.admin.async;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jarvis.BalanceGame.model.dto.TotalDTO;
import com.jarvis.BalanceGame.service.TotalService;

@Controller
@RequestMapping("/admin")
public class AdminChartAsync {

	@Autowired
	private TotalService totalService;

	@PostMapping("/adminChartAsync")
	public @ResponseBody String adminChartAsync(TotalDTO tDTO, Gson gson) {
		System.out.println("관리자 차트 비동기 기능 ");
		List<TotalDTO> totalDatas = totalService.selectAll(tDTO);
		System.out.println("포인트 통계 데이터 : " + totalDatas);
		// 데이터를 JSON 형식으로 변환하여 반환
		String jsonData = gson.toJson(totalDatas);
		return jsonData;

	}

}
