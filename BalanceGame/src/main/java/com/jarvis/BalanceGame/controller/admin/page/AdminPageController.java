package com.jarvis.BalanceGame.controller.admin.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.PaymentDTO;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.LetterService;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.PaymentService;
import com.jarvis.BalanceGame.service.QuestionService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminPageController {

	@Autowired
	private LetterService letterService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("/adminPage")
	public String adminPageController(LetterDTO lDTO, QuestionDTO qDTO, MemberDTO mDTO, PaymentDTO pDTO, Model model, HttpSession session) {
		
		qDTO.setSearchCondition("questionCount");
		qDTO.setQuestionAccess("F");
		QuestionDTO qDTOApproveCnt = questionService.selectOne(qDTO);
		System.out.println(qDTOApproveCnt);
		
		qDTO.setSearchCondition("questionCount");
		qDTO.setQuestionAccess("T");
		QuestionDTO qDTOTotalCnt = questionService.selectOne(qDTO);
		System.out.println(qDTOTotalCnt);
		
		mDTO.setSearchCondition("memberCount");
		mDTO = memberService.selectOne(mDTO);
		System.out.println(mDTO);
		
		pDTO = paymentService.selectOne(pDTO);
		System.out.println(pDTO);
		
		
		String loginId = (String)session.getAttribute("loginId");
		
		lDTO.setLoginId(loginId);
		lDTO.setSearchCondition("unReadMessage");
		List<LetterDTO> lDatas = letterService.selectAll(lDTO);
		System.out.println(lDatas);
		if (lDatas.size() <= 0) {
			System.out.println("건의사항 : null");
		}
		System.out.println("건의사항 데이터는 있음");
		model.addAttribute("qDTOApproveCnt", qDTOApproveCnt);
		model.addAttribute("qDTOTotalCnt", qDTOTotalCnt);
		model.addAttribute("memberDatas", mDTO);
		model.addAttribute("paymentDatas", pDTO);
		model.addAttribute("letterDatas", lDatas);
		
		return "admin/adminMain";
	}
}


