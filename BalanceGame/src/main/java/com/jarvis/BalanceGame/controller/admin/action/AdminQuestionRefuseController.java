package com.jarvis.BalanceGame.controller.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.MailServiceImpl;
import com.jarvis.BalanceGame.service.QuestionService;
//한글코딩
	//모델에서 사용자가 올리는 순간 기본값은 false로 승인되지 않게 해놈
	//그럼 거절이유를 적어서 사용자에게 보내주어야함 
	//이 거절을 하는 action이 필요가 있나?

@Controller
@RequestMapping("/admin")
public class AdminQuestionRefuseController {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private MailServiceImpl mailService;
	
	// 관리자가 문제를 거절하는 기능
	@PostMapping("/questionRefuse")
	public String adminTitleRefuseController(QuestionDTO qDTO, Model model) {
		
		// qDTO.qeustionId를 모델로 보내주고 모델에서 join해서 해당 회원의 이메일을 가져오고 그 가져온 이메일을 인자로 집어넣음
		// 사용자에게 이메일 전송을 위해 해당 문제 정보 조회
		qDTO.setSearchCondition("sendEmail");
		QuestionDTO data = questionService.selectOne(qDTO);
		System.out.println(data);
		// 이메일 전송
		mailService.sendMessage(data);
		// 문제 삭제 실행
		boolean flag = questionService.delete(qDTO);
		
		// 실패 처리
		if(!flag) {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "실패했습니다");
			model.addAttribute("redirect", "/admin/adminPage");
			return "alert";
		}
		// 성공 처리
		model.addAttribute("status", "success");
		model.addAttribute("msg", "거절했습니다");
		model.addAttribute("redirect", "/admin/adminPage");
		return "alert";
	}
	
}
