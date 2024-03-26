package com.jarvis.BalanceGame.controller.user.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jarvis.BalanceGame.SavePictures;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.QuestionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class MakeQuestionController {
	@Autowired
	private SavePictures savePictures;
	
	@Autowired
	private QuestionService questionService;
	

	@PostMapping("/makeQuestion")
	public String MakeTitleController(QuestionDTO qDTO, Model model, HttpSession session,
	        @RequestParam("file") List<MultipartFile> files, HttpServletRequest request) throws IOException {
	    

	    try {
	        List<String> fileNames = savePictures.storeImages(files, request.getServletContext().getRealPath("/"));

	        // 이미지 파일명을 DTO에 설정
	        qDTO.setAnswerAImg(fileNames.get(0));
			qDTO.setAnswerBImg(fileNames.get(1));
			qDTO.setSearchCondition("createQuestionUser");
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
			model.addAttribute("redirect", "/user/questionListPage");
			return "alert";
	    } catch (IOException e) {
	        e.printStackTrace();
	        // 파일 업로드 실패 처리
	        model.addAttribute("status", "fail");
	        model.addAttribute("msg", "파일 업로드 실패");
	        model.addAttribute("redirect", "/");
	        return "alert";
	    }
	}
}