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
import com.jarvis.BalanceGame.model.dto.AdvertisementDTO;
import com.jarvis.BalanceGame.service.AdvertisementService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminAdvertisementCreateController {

	@Autowired
	private SavePictures savePictures;
	
	@Autowired
	private AdvertisementService advertisementService;
	
	@PostMapping("/adminAdvertisementCreate")
	public String adminAdvertisementCreateController(AdvertisementDTO aDTO, Model model, @RequestParam("file") List<MultipartFile> files,
			HttpServletRequest request) {
		
		try {
			List<String> fileNames = savePictures.storeImages(files, request.getServletContext().getRealPath("/"));

			// 이미지 파일명을 DTO에 설정
			System.out.println(fileNames.get(0));
			aDTO.setAdvertisementImg(fileNames.get(0));
			boolean flag = 	advertisementService.insert(aDTO);
		
			if (!flag) {
				model.addAttribute("status", "fail");
				model.addAttribute("msg", "광고추가 실패했습니다");
				model.addAttribute("redirect", "/admin/adminPage");
				return "alert";
			}
			
			model.addAttribute("status", "success");
			model.addAttribute("msg", "광고추가 성공했습니다");
			model.addAttribute("redirect", "/admin/adminPage");
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
