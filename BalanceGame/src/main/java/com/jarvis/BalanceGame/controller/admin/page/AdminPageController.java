package com.jarvis.BalanceGame.controller.admin.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.PageInfoDTO;
import com.jarvis.BalanceGame.model.dto.PaymentDTO;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.LetterService;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.PageInfoService;
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
	
	@Autowired
	private PageInfoService pageInfoService;
	
	
	@GetMapping("/adminPage")
	public String adminPageController(LetterDTO lDTO, QuestionDTO qDTO, PageInfoDTO piDTO, MemberDTO mDTO, PaymentDTO pDTO, Model model, HttpSession session) {
		
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
		
		pDTO.setSearchCondition("viewOnepaymentTotal");
		pDTO = paymentService.selectOne(pDTO);
		System.out.println(pDTO);
		
		
		String loginId = (String)session.getAttribute("loginId");
		
		if(piDTO.getCurrentPage() == 0) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<");
			piDTO.setCurrentPage(1);
		}
		
		piDTO.setLoginId(loginId);
		piDTO.setPasingnationSize(10);
		
		piDTO.setOffset(pageInfoService.calculateOffset(piDTO));
		System.out.println(piDTO.getOffset());
		piDTO.setSearchCondition("unReadMessageAdmin");
		System.out.println("pDTO" + piDTO);
		List<PageInfoDTO> datas = pageInfoService.selectAll(piDTO);
		System.out.println("datas"+datas);
		
		
		lDTO.setLetterType("suggestion");
		lDTO.setSearchCondition("messageCntAdmin");
		lDTO = letterService.selectOne(lDTO);
		System.out.println(lDTO);
		piDTO.setTotalRows(lDTO.getCnt());
		int totalPage = pageInfoService.calcTotalPages(piDTO);	// 총페이지 수
		

		System.out.println(totalPage);
		
			model.addAttribute("letterDatas", datas);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("page", piDTO.getCurrentPage());
			System.out.println("건의사항 데이터는 있음");
			model.addAttribute("qDTOApproveCnt", qDTOApproveCnt);
			model.addAttribute("qDTOTotalCnt", qDTOTotalCnt);
			model.addAttribute("memberDatas", mDTO);
			model.addAttribute("paymentDatas", pDTO);

		return "admin/adminMain";
	}
}


