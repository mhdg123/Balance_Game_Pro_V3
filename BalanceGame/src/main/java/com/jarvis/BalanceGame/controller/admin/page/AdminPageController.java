//package com.jarvis.BalanceGame.controller.admin.page;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.jarvis.BalanceGame.model.dto.LetterDTO;
//import com.jarvis.BalanceGame.model.dto.MemberDTO;
//import com.jarvis.BalanceGame.model.dto.PaymentDTO;
//import com.jarvis.BalanceGame.model.dto.QuestionDTO;
//import com.jarvis.BalanceGame.model.dto.SuggestionDTO;
//import com.jarvis.BalanceGame.service.LetterService;
//import com.jarvis.BalanceGame.service.MemberService;
//import com.jarvis.BalanceGame.service.PaymentService;
//import com.jarvis.BalanceGame.service.QuestionService;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminPageController {
//
//	@Autowired
//	private LetterService letterService;
//	@Autowired
//	private QuestionService questionService;
//	@Autowired
//	private PaymentService paymentService;
//	@Autowired
//	private MemberService memberService;
//	
//	
//	@GetMapping("/adminPage")
//	public String AdminPageController(LetterDTO lDTO, QuestionDTO qDTO, MemberDTO mDTO, PaymentDTO pDTO, Model model) {
//		
//		qDTO.setSearchCondition("총문제수");
//		qDTO.setQuestionAccess("F");
//		QuestionDTO qDTOApproveCnt = questionService.selectOne(qDTO);
//		
//		qDTO.setSearchCondition("총문제수");
//		qDTO.setQuestionAccess("T");
//		QuestionDTO qDTOTotalCnt = questionService.selectOne(qDTO);
//		
//		mDTO.setSearchCondition("회원인원수");
//		mDTO = memberService.selectOne(mDTO);
//		
//		pDTO.setSearchCondition("총후원금액");
//		pDTO = paymentService.selectOne(pDTO);
//		
//		lDTO.setSearchCondition("전체조회");
//		List<SuggestionDTO> sugDatas = letterService.selectAll(lDTO);
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
//		model.addAttribute("pDTO", pDTO);
//
//		return "adminMain";
//	}
//}
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
