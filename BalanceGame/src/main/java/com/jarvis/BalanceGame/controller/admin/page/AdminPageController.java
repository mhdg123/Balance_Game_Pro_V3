//package com.jarvis.BalanceGame.controller.admin.page;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.jarvis.BalanceGame.model.dto.MemberDTO;
//import com.jarvis.BalanceGame.model.dto.QuestionDTO;
//import com.jarvis.BalanceGame.service.MemberService;
//import com.jarvis.BalanceGame.service.QuestionService;
//
//@Controller
//public class AdminPageController {
//
//	@Autowired
//	private SuggestService suggestService;
//	@Autowired
//	private QuestionService questionService;
//	@Autowired
//	private SupportService supportService;
//	@Autowired
//	private MemberService memberService;
//	
//	
//	@RequestMapping("/adminPage")
//	public String AdminPageController(SuggestionDTO sugDTO, QuestionDTO qDTO, MemberDTO mDTO, SupportDTO sDTO, Model model) {
//		
//		qDTO.setSearchCondition("총문제수");
//		qDTO.setqAccess("F");
//		QuestionDTO qDTOApproveCnt = questionService.selectOne(qDTO);
//		
//		qDTO.setSearchCondition("총문제수");
//		qDTO.setqAccess("T");
//		QuestionDTO qDTOTotalCnt = questionService.selectOne(qDTO);
//		
//		mDTO.setSearchCondition("회원인원수");
//		mDTO = memberService.selectOne(mDTO);
//		
//		sDTO.setSearchCondition("총후원금액");
//		sDTO = supportService.selectOne(sDTO);
//		
//		sugDTO.setSearchCondition("전체조회");
//		List<SuggestionDTO> sugDatas = suggestService.selectAll(sugDTO);
//		System.out.println(sugDatas + "sugDatas <<<<<<<<");
//
//		if (sugDatas.size() <= 0) {
//			System.out.println("건의사항 : null");
//		}
//		System.out.println("건의사항 데이터는 있음");
//		System.out.println("sugDatas"+sugDatas);
//		model.addAttribute("qDTOApproveCnt", qDTOApproveCnt);
//		model.addAttribute("qDTOTotalCnt", qDTOTotalCnt);
//		model.addAttribute("mDTO", mDTO);
//		model.addAttribute("sDTO", sDTO);
//
//		return "adminMain";
//	}
//}
