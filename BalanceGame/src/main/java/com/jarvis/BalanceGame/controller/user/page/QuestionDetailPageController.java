package com.jarvis.BalanceGame.controller.user.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.AdvertisementDTO;
import com.jarvis.BalanceGame.model.dto.CommentDTO;
import com.jarvis.BalanceGame.model.dto.PageInfoDTO;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.AdvertisementService;
import com.jarvis.BalanceGame.service.CommentService;
import com.jarvis.BalanceGame.service.PageInfoService;
import com.jarvis.BalanceGame.service.QuestionService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class QuestionDetailPageController {

	@Autowired
	private AdvertisementService advertisementService;
	
	@Autowired
	private QuestionService questionService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private PageInfoService pageInfoService;
	
	@GetMapping("/questionDetailPage")
	public String titleDetailPageController(QuestionDTO qDTO,PageInfoDTO pDTO, CommentDTO cDTO, Model model, HttpSession session, AdvertisementDTO aDTO) {
		String loginId = (String) session.getAttribute("loginId");
		aDTO.setSearchCondition("adRandomChoice");
		AdvertisementDTO adData = advertisementService.selectOne(aDTO);
		System.out.println("게임 페이지 광고 데이터 : " + adData );

		qDTO.setWriter(loginId);
		qDTO.setSearchCondition("questionDetail");
		qDTO = questionService.selectOne(qDTO);
		
		if(pDTO.getCurrentPage() == 0) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<");
			pDTO.setCurrentPage(1);
		}
		pDTO.setLoginId(loginId);
		pDTO.setPasingnationSize(10);
		
		pDTO.setOffset(pageInfoService.calculateOffset(pDTO));
		System.out.println(pDTO.getOffset());
		pDTO.setSearchCondition("questionComments");
		System.out.println("pDTO" + pDTO);
		List<PageInfoDTO> datas = pageInfoService.selectAll(pDTO);

		cDTO.setSearchCondition("commentsCntQuestion");
		cDTO = commentService.selectOne(cDTO);
		System.out.println(cDTO);
		pDTO.setTotalRows(cDTO.getCnt());
		int totalPage = pageInfoService.calcTotalPages(pDTO);	// 총페이지 수
		
		
		if(datas != null) {
			model.addAttribute("questionData", qDTO);
			model.addAttribute("commentDatas", datas);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("page", pDTO.getCurrentPage());
		}else {
			model.addAttribute("questionData", qDTO);
			model.addAttribute("commentDatas", datas);
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "등록된 댓글이 없습니다.");
			model.addAttribute("redirect", "");
			return "alert";
		}
		
		model.addAttribute("advertisementData",adData); // 광고 데이터
		return "/user/questionDetail";

	}
}



