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

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
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
		System.out.println("관리자 아이템 수정 파라미터 데이터 : " + iDTO);
		System.out.println("관리자 아이템 수정 원본 이미지 데이터 : " + originalImg);
		try {
			List<String> fileNames = savePictures.storeImages(files, request.getServletContext().getRealPath("/"));
			if (iDTO.getItemImg().equals("") || iDTO.getItemImg().equals(null)) {
				iDTO.setItemImg(originalImg);
				System.out.println("관리자 아이템 이미지 파일 수정 안해서 원본 데이터 다시 넣어줌 : " + iDTO.getItemImg());
			} else {
				System.out.println("관리자 아이템 이미지 파일 처음 추가 ");
				iDTO.setItemImg(iDTO.getItemImg());
			}
			boolean flag = itemService.update(iDTO);
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

	}
}
