package com.jarvis.BalanceGame.controller.admin.action;

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

@Controller
@RequestMapping("/admin")
public class AdminQuestionAccessController {

	@Autowired
	private SavePictures savePictures;
	
	
	@Autowired
	private QuestionService questionService;

	// 관리자가 문제를 승인하는 기능
	@PostMapping("/questionAccess")
	public String adminTitleAccessController(QuestionDTO qDTO, Model model,
			@RequestParam("file") List<MultipartFile> files, HttpServletRequest request,
			@RequestParam("retouch") List<String> retouch) {

		
		
		try {
			// 업로드된 파일들을 서버에 저장하고 파일명들을 반환
			List<String> fileNames = savePictures.storeImages(files, request.getServletContext().getRealPath("/"));
			
			// 이미지 파일명을 DTO에 설정
			if (retouch.get(0).equals("T")) {
				//저장된 파일 삭제 >> 새 이미지 대체
				savePictures.deleteImage(qDTO.getAnswerAImg(),request.getServletContext().getRealPath("/"));
				System.out.println("원래 파일 A" + qDTO.getAnswerAImg());
				System.out.println("변경파일 A" +fileNames.get(0));
	            qDTO.setAnswerAImg(fileNames.get(0));
	            
	        }
			// 이미지 파일명을 DTO에 설정
			if (retouch.get(1).equals("T")) {
				System.out.println("원래 파일 B" + qDTO.getAnswerBImg());
				//저장된 파일 삭제 >> 새 이미지 대체
				savePictures.deleteImage(qDTO.getAnswerBImg(),request.getServletContext().getRealPath("/"));
				System.out.println("변경파일 B" +fileNames.get(1));
				qDTO.setAnswerBImg(fileNames.get(1));
			}
			System.out.println("승인할 문제 번호 : " + qDTO.getQuestionId());
			
			System.out.println(qDTO.getAnswerA());
			System.out.println(qDTO.getAnswerAImg());
			System.out.println(qDTO.getAnswerB());
			System.out.println(qDTO.getAnswerBImg());
			
			// 문제 승인 처리를 위해 DTO 설정
			qDTO.setQuestionAccess("T");
			
			qDTO.setSearchCondition("updateQuestion");
			boolean flag = questionService.update(qDTO);
			
			
			System.out.println("문제 승인 한 결과 데이터 : " + qDTO);
			// 실패 처리
			if (!flag) {
				model.addAttribute("status", "fail");
				model.addAttribute("msg", "실패했습니다");
				model.addAttribute("redirect", "/admin/adminPage");
				return "alert";

			}
			// 성공 처리
			model.addAttribute("status", "success");
			model.addAttribute("msg", "성공했습니다");
			model.addAttribute("redirect", "/admin/questionManagementPage");
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