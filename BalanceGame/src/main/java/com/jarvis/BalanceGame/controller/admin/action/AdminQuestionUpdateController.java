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
public class AdminQuestionUpdateController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private SavePictures savePictures;
	
	@PostMapping("/questionUpdate")
	public String adminTitleUpdateController(QuestionDTO qDTO, Model model,
			@RequestParam("questionImgOriginal1") String originalImg1,@RequestParam("questionImgOriginal2") String originalImg2, @RequestParam("file") List<MultipartFile> files,
			HttpServletRequest request) {
		System.out.println("관리자 문제PK 파라미터 : " + qDTO.getQuestionId());
		System.out.println("관리자 문제 출제 유저 아이디 :  " + qDTO.getWriter());
		System.out.println("관리자 문제 제목 파라미터 : " + qDTO.getTitle());
		System.out.println("관리자 문제 답변A 파라미터 : " + qDTO.getAnswerA());
		System.out.println("관리자 문제 답변B 파라미터 : " + qDTO.getAnswerB());
		System.out.println("관리자 문제 설명 파라미터 : " + qDTO.getExplanation());
		
		
		qDTO.setSearchCondition("questionDetail");
		String originalImgSaveData1 = questionService.selectOne(qDTO).getAnswerAImg();
		String originalImgSaveData2 = questionService.selectOne(qDTO).getAnswerBImg();

		try {
			List<String> fileNames = savePictures.storeImages(files, request.getServletContext().getRealPath("/"));

			if (qDTO.getAnswerAImg().isEmpty()) { // 이미지를 변경하지 않고 수정
				qDTO.setAnswerAImg(originalImg1);
				System.out.println("관리자 아이템 이미지 파일 수정 안했으므로 원본 데이터 유지 : " + qDTO.getAnswerAImg());
			} else if (!originalImgSaveData1.equals(fileNames.get(0))) { // 이미지를 변경하고 수정 -> 기존 이미지 삭제 후 새 이미지로 대체
				System.out.println("기존 이미지 " + originalImgSaveData1 + "을(를) " + fileNames.get(0) + "으로 수정함");
				savePictures.deleteImage(originalImgSaveData1, request.getServletContext().getRealPath("/"));
				System.out.println("기존 이미지가 새로운 이미지로 변경됨");
				System.out.println("관리자 아이템 새 이미지 파일로 수정됨");
				qDTO.setAnswerAImg((fileNames.get(0)));
			}
			if (qDTO.getAnswerBImg().isEmpty()) { // 이미지를 변경하지 않고 수정
				qDTO.setAnswerBImg(originalImg2);
				System.out.println("관리자 아이템 이미지 파일 수정 안했으므로 원본 데이터 유지 : " + qDTO.getAnswerBImg());
			} else if (!originalImgSaveData2.equals(fileNames.get(1))) { // 이미지를 변경하고 수정 -> 기존 이미지 삭제 후 새 이미지로 대체
				System.out.println("기존 이미지 " + originalImgSaveData2 + "을(를) " + fileNames.get(1) + "으로 수정함");
				savePictures.deleteImage(originalImgSaveData2, request.getServletContext().getRealPath("/"));
				System.out.println("기존 이미지가 새로운 이미지로 변경됨");
				System.out.println("관리자 아이템 새 이미지 파일로 수정됨");
				qDTO.setAnswerBImg(fileNames.get(1));
			}
			qDTO.setSearchCondition("updateQuestion");
			if(qDTO.getQuestionAccess() == null) {
				qDTO.setQuestionAccess("F");
			}
			boolean flag = questionService.update(qDTO);
			if(!flag) {
				model.addAttribute("status", "fail");
				model.addAttribute("msg", "실패했습니다");
				model.addAttribute("redirect", "/admin/adminPage");
				return "alert";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("관리자 문제 수정 성공");
		model.addAttribute("status", "success");
		model.addAttribute("msg", "수정되었습니다");
		model.addAttribute("redirect", "/admin/questionManagementPage");
		return "alert";
	}
}

