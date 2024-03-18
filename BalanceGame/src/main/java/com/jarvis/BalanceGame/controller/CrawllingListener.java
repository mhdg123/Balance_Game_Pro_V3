package com.jarvis.BalanceGame.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.QuestionService;

import jakarta.servlet.annotation.WebListener;
@Controller
@WebListener
public class CrawllingListener {

	@Autowired
	private QuestionService questionService;
	
	
	public String crawllingListener(QuestionDTO qDTO, Model model) {
		
		System.out.println("로그0");
		
		qDTO.setSearchCondition("총문제수");
		qDTO.setQuestionAccess("T");
		if(questionService.selectOne(qDTO).getQuestionCount()>0) {
			System.out.println("로그: "+ questionService.selectAll(qDTO));
			return "";
		}
		
		System.out.println("로그1");
		
		// 데이터 가져올 주소값
		String url = "https://zico8282.tistory.com/entry/%EC%9B%B9-%ED%81%AC%EB%A1%A4%EB%A7%81-%EB%8D%B0%EC%9D%B4%ED%84%B0";

		// 웹 페이지 정보를 담을 그릇
		Document doc = null;

		try {
			// jsoup으로 웹페이지에 접근해 데이터 가져옴
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 문제 랜덤으로 데이터 가져오기
		Elements questions = doc.select(".tt_article_useless_p_margin span:contains(#)");

		int i = 0;
		// datas에 QuestionDTO 타입으로 저장 
		List<QuestionDTO> datas = new ArrayList<QuestionDTO>();

		for (i = 0; i < questions.size(); i++) {
			qDTO = new QuestionDTO();
			String title = questions.get(i).text();
			String resultTitle = title.replaceAll("#", "");
			qDTO.setTitle(resultTitle);
			datas.add(qDTO);

		}

		Elements answer = doc.select(".tt_article_useless_p_margin p:contains(^)");
		i = 0;
		for (int j = 0; j < answer.size(); j += 2) {
			String answer_A = answer.get(j).text();
			String resultAns_A = answer_A.replaceAll("\\^", "");
			datas.get(i).setAnswerA(resultAns_A);

			String answer_B = answer.get(j + 1).text();
			String resultAns_B = answer_B.replaceAll("\\^", "");
			datas.get(i).setAnswerB(resultAns_B);
			datas.get(i).setWriter("관리자");
			i++;
		}
		Elements explains = doc.select(".tt_article_useless_p_margin p:contains(~)");
		System.out.println("[로그] explains: " + explains);
		i=0;
		for(int j=0; i<explains.size(); j++) {
			String explain = explains.get(j).text();
			System.out.println("log: explain: " + explain);
			String resultExp = explain.replaceAll("~","");
			System.out.println("log: resultExp: " + resultExp);
			datas.get(i).setExplanation(resultExp);
			i++;
		}
		for(QuestionDTO data : datas) {
			data.setSearchCondition("관리자문제생성");
			questionService.insert(data);
		}
		
		return "";
	}
}
