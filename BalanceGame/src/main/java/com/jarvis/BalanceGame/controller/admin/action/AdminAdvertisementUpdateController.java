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

	// 광고 정보를 업데이트하는 기능
	@PostMapping("/adminAdvertisementUpdate")
	public String adminAdvertisementUpdateController(AdvertisementDTO aDTO, Model model,
			@RequestParam("advertisementImgOriginal") String originalImg, @RequestParam("file") List<MultipartFile> files,
			HttpServletRequest request) {
		
		
		// 광고 정보 확인
		aDTO.setSearchCondition("adViewOne");
		advertisementService.selectOne(aDTO);
		String originalImgSaveData = advertisementService.selectOne(aDTO).getAdvertisementImg();

		System.out.println("관리자 아이템 수정 파라미터 데이터 : " + aDTO);
		System.out.println("관리자 아이템 수정 원본 이미지 데이터 : " + originalImg);

		try {
			List<String> fileNames = savePictures.storeImages(files, request.getServletContext().getRealPath("/"));
			
			// 이미지를 변경하지 않고 수정
			if (aDTO.getAdvertisementImg().isEmpty()) {
				aDTO.setAdvertisementImg(originalImg);
				System.out.println("관리자 아이템 이미지 파일 수정 안했으므로 원본 데이터 유지 : " + aDTO.getAdvertisementImg());
				
			// 이미지를 변경하고 수정 -> 기존 이미지 삭제 후 새 이미지로 대체
			} else if (!originalImgSaveData.equals(fileNames.get(0))) { 
				System.out.println("기존 이미지 " + originalImgSaveData + "을(를) " + fileNames.get(0) + "으로 수정함");
				savePictures.deleteImage(originalImgSaveData, request.getServletContext().getRealPath("/"));
				System.out.println("기존 이미지가 새로운 이미지로 변경됨");
				System.out.println("관리자 아이템 새 이미지 파일로 수정됨");
				aDTO.setAdvertisementImg(fileNames.get(0));
			}
			//업데이트 불가 모델 확인해 보아야함
			
			// 업데이트
			aDTO.setSearchCondition("adModification");
			boolean flag = advertisementService.update(aDTO);

			// 실패 처리
			if (!flag) {
				model.addAttribute("status", "fail");
				model.addAttribute("msg", "정보 수정에 실패했습니다.");
				model.addAttribute("redirect", "/admin/adminPage");
				return "alert";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 성공 처리
		model.addAttribute("status", "success");
		model.addAttribute("msg", "광고 정보가 수정되었습니다.");
		model.addAttribute("redirect", "/admin/adminAdvertisementManagementPage");
		return "alert";

	}
}
