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
import com.jarvis.BalanceGame.model.dto.AdvertisementDTO;
import com.jarvis.BalanceGame.service.AdvertisementService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminAdvertisementUpdateController {
	
	@Autowired
	private SavePictures savePictures;

	@Autowired
	private AdvertisementService advertisementService;

	@PostMapping("/adminAdvertisementUpdate")
	public String adminAdvertisementUpdateController(AdvertisementDTO aDTO, Model model,
			@RequestParam("advertisementImgOriginal") String originalImg,
			@RequestParam("file") List<MultipartFile> files, HttpServletRequest request) {

		
		try {
			List<String> fileNames = savePictures.storeImages(files, request.getServletContext().getRealPath("/"));
			aDTO.setSearchCondition("adModification");
			if (aDTO.getAdvertisementImg().equals("") || aDTO.getAdvertisementImg().equals(null)) {
				aDTO.setAdvertisementImg(originalImg);
				System.out.println("파일명1 : " + fileNames.get(0));
				System.out.println("관리자 아이템 이미지 파일 수정 안해서 원본 데이터 다시 넣어줌 : " + aDTO.getAdvertisementImg());
			} else {
				System.out.println("관리자 아이템 이미지 파일 처음 추가 ");
				System.out.println("파일명2 : " + fileNames.get(0));
				aDTO.setAdvertisementImg(aDTO.getAdvertisementImg());
			}
			boolean flag = advertisementService.update(aDTO);
			if (!flag) {
				model.addAttribute("status", "fail");
				model.addAttribute("msg", "정보수정 실패했습니다");
				model.addAttribute("redirect", "/admin/adminItemManagementPage");
				return "alert";
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("status", "success");
		model.addAttribute("msg", "아이템 정보가 수정되었습니다.");
		model.addAttribute("redirect", "/admin/adminItemManagementPage");
		return "alert";

		// System.out.println("관리자 광고 수정 파리미터 데이터 : " + aDTO);
//		System.out.println("관링자 광고 수정 원본 이미지 데이터 :  " + originalImg);
//		aDTO.setSearchCondition("adModification");
//		if(aDTO.getAdvertisementImg() == "") {
//			System.out.println("원본 데이터 넣어주기 ");
//			aDTO.setAdvertisementImg(originalImg);
//		}
//		boolean flag = 	advertisementService.update(aDTO);
//		if (!flag) {
//			model.addAttribute("status", "fail");
//			model.addAttribute("msg", "광고수정 실패했습니다");
//			model.addAttribute("redirect", "/admin/adminAdvertisementManagementPage");
//			return "alert";
//		}
//		model.addAttribute("status", "success");
//		model.addAttribute("msg", "광고수정 성공했습니다");
//		model.addAttribute("redirect", "/admin/adminAdvertisementManagementPage");

//		return "alert";

	}
}
