package com.jarvis.BalanceGame.controller.admin.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jarvis.BalanceGame.SavePictures;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.QuestionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//문제생성
//관리자페이지에서 문제를 작성
//뷰에서 문제를 작성하면 parameter값으로 받아옴 
//해당 DTO에 set함 
//작성한 것을 모델의 insert함
@Controller
@RequestMapping("/admin")
public class AdminQuestionCreateController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private SavePictures savePictures;

	@PostMapping("/titleCreate")
	public String adminTitleCreateController(QuestionDTO qDTO, Model model, HttpSession session,
			@RequestParam("file") List<MultipartFile> files, HttpServletRequest request) throws IOException {
		System.out.println("관리자 문제 생성 기능 ");
		System.out.println("관리자 문제 생성 제목 데이터 : " + qDTO.getTitle());
		System.out.println("관리자 문제 생성 선택지A 데이터 :  " + qDTO.getAnswerA());
		System.out.println("관리자 문제 생성 선택지B 데이터 :  " + qDTO.getAnswerB());
		System.out.println("관리자 문제 생성 출제 이유 데이터 : " + qDTO.getExplanation());
		qDTO.setSearchCondition("createQuestionAdmin");

		try {
			List<String> fileNames = savePictures.storeImages(files, request.getServletContext().getRealPath("/"));

			// 이미지 파일명을 DTO에 설정
			qDTO.setAnswerAImg(fileNames.get(0));
			qDTO.setAnswerBImg(fileNames.get(1));
			qDTO.setSearchCondition("createQuestionAdmin");
			qDTO.setWriter((String) session.getAttribute("loginId")); // 로그인 아이디

			// 문제 출제 성공
			if (!questionService.insert(qDTO)) {
				model.addAttribute("status", "fail");
				model.addAttribute("msg", "실패");
				model.addAttribute("redirect", "/");
				return "alert";

			}

			model.addAttribute("status", "success");
			model.addAttribute("msg", "성공");
			model.addAttribute("redirect", "/admin/questionManagementPage");
			return "alert";
		} catch (IOException e) {
			e.printStackTrace();
			// 파일 업로드 실패 처리
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "파일 업로드 실패");
			model.addAttribute("redirect", "/admin/adminPage");
			return "alert";
		}
	}
}