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
import com.jarvis.BalanceGame.model.dto.ItemDTO;
import com.jarvis.BalanceGame.service.ItemService;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
@MultipartConfig
public class AdminItemCreateController {
	@Autowired
	private SavePictures savePictures;

	@Autowired
	private ItemService itemService;

	// 아이템 생성 기능
	@PostMapping("/adminItemCreate")
	public String adminItemCreateController(ItemDTO iDTO, Model model, @RequestParam("file") List<MultipartFile> files,
			HttpServletRequest request) {
		System.out.println("관리자 아이템 등록 데이터 : " + iDTO);

		try {
			// 업로드된 파일들을 서버에 저장하고 파일명들을 반환
			List<String> fileNames = savePictures.storeImages(files, request.getServletContext().getRealPath("/"));

			// 이미지 파일명을 DTO에 설정
			System.out.println(fileNames.get(0));
			iDTO.setItemImg(fileNames.get(0));
			
			// 아이템을 데이터베이스에 저장
			boolean flag = itemService.insert(iDTO);

			// 실패 처리
			if (!flag) {
				model.addAttribute("status", "fail");
				model.addAttribute("msg", "아이템추가 실패했습니다");
				model.addAttribute("redirect", "/admin/adminItemManagementPage");
				return "alert";
			}
			// 성공 처리
			model.addAttribute("status", "success");
			model.addAttribute("msg", "성공");
			model.addAttribute("redirect", "/admin/adminItemManagementPage");
			return "alert";
		} catch (IOException e) {
			e.printStackTrace();
			// 파일 업로드 실패 처리
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "파일 업로드 실패");
			model.addAttribute("redirect", "/admin/adminItemManagementPage");
			return "alert";
		}

	}
}
