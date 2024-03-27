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

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminItemUpdateController {

	@Autowired
	private SavePictures savePictures;

	@Autowired
	private ItemService itemService;

	@PostMapping("adminItemUpdate")
	public String adminItemUpdateController(ItemDTO iDTO, Model model,
			@RequestParam("itemImgOriginal") String originalImg, @RequestParam("file") List<MultipartFile> files,
			HttpServletRequest request) {
		iDTO.setSearchCondition("itemViewOne");
		String originalImgSaveData = itemService.selectOne(iDTO).getItemImg(); // 기존 데이터베이스에 저장된 이미지

		System.out.println("관리자 아이템 수정 파라미터 데이터 : " + iDTO);
		System.out.println("관리자 아이템 수정 원본 이미지 데이터 : " + originalImg);

		try {
			List<String> fileNames = savePictures.storeImages(files, request.getServletContext().getRealPath("/"));

			if (iDTO.getItemImg().isEmpty()) { // 이미지를 변경하지 않고 수정
				iDTO.setItemImg(originalImg);
				System.out.println("관리자 아이템 이미지 파일 수정 안했으므로 원본 데이터 유지 : " + iDTO.getItemImg());
			} else if (!originalImgSaveData.equals(fileNames.get(0))) { // 이미지를 변경하고 수정 -> 기존 이미지 삭제 후 새 이미지로 대체
				System.out.println("기존 이미지 " + originalImgSaveData + "을(를) " + fileNames.get(0) + "으로 수정함");
				savePictures.deleteImage(originalImgSaveData, request.getServletContext().getRealPath("/"));
				System.out.println("기존 이미지가 새로운 이미지로 변경됨");
				System.out.println("관리자 아이템 새 이미지 파일로 수정됨");
				iDTO.setItemImg(fileNames.get(0));
			}
			boolean flag = itemService.update(iDTO);
			if (!flag) {
				model.addAttribute("status", "fail");
				model.addAttribute("msg", "정보 수정에 실패했습니다.");
				model.addAttribute("redirect", "/admin/adminItemManagementPage");
				return "alert";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("status", "success");
		model.addAttribute("msg", "아이템 정보가 수정되었습니다.");
		model.addAttribute("redirect", "/admin/adminItemManagementPage");
		return "alert";
	}
}
