package com.jarvis.BalanceGame.controller.user.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.QuestionService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class MakeQuestionController {
	@Autowired
	private QuestionService questionService;

	@PostMapping("/makeQuestion")
	public String MakeTitleController(QuestionDTO qDTO, Model model, HttpSession session,
			@RequestParam("file") List<MultipartFile> files) throws IOException {
		// 나머지 데이터는 커멘드 객체인 DTO에 자동으로 저장되고
		// MultipartFile인 이미지는 file이라는 이름으로 받아오게된다

		// 절대경로로 저장하고 싶은 파일에 저장한다
		// 절대 경로로 하는이유 :
		// 서버 환경에서는 상대 경로를 사용할 경우 예상치 못한 문제가 발생할 수 있다
		String uploadDir = "C:/phg/Balance_Game_Pro_V3/BalanceGame/src/main/resources/static/upload/";

		try {
			// 파일 저장
			List<String> fileNames = new ArrayList<>();
			for (MultipartFile file : files) {
				// 파일을 저장할때 이름이 같으면 충돌이 발생하기 때문에
				// 파일 이름을 랜덤하게 생성하는 방법으로
				// UUID를 사용하여 파일이름을 랜덤으로 저장한다
				// UUID는 고유한 식별자를 생성하는 라이브러리
				String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
				String filePath = uploadDir + fileName;
				File dest = new File(filePath);
				file.transferTo(dest);
				fileNames.add(fileName);
				System.out.println("fileName" + fileName);
			}

			// DTO 설정
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