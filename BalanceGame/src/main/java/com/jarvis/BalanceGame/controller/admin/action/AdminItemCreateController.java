package com.jarvis.BalanceGame.controller.admin.action;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jarvis.BalanceGame.model.dto.ItemDTO;
import com.jarvis.BalanceGame.service.ItemService;

import jakarta.servlet.annotation.MultipartConfig;

@Controller
@RequestMapping("/admin")
@MultipartConfig
public class AdminItemCreateController {
	private static final String UPLOAD_DIR = "C:\\Balance_Game_Pro_V3\\BalanceGame\\src\\main\\resources\\static\\upload\\"; // 파일 업로드 절대경로


    @Autowired
    private ItemService itemService;

    @PostMapping("/adminItemCreate")
    public String adminItemCreateController(ItemDTO iDTO, Model model, @RequestParam("file") MultipartFile file) {
        System.out.println("관리자 아이템 등록 데이터 : " + iDTO);
        if (file.isEmpty()) {
            return "파일이 비어 있습니다.";
        }
        try {
            // 업로드 디렉토리가 없으면 생성
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            String fileName = file.getOriginalFilename();
            // 업로드 파일 경로 설정
            String filePath = UPLOAD_DIR + fileName;
            File dest = new File(filePath);
            iDTO.setItemImg(fileName);
            boolean flag = itemService.insert(iDTO);

            if (!flag) {
                model.addAttribute("status", "fail");
                model.addAttribute("msg", "아이템추가 실패했습니다");
                model.addAttribute("redirect", "/admin/adminPage");
                return "alert";
            }
            // 파일 저장
            file.transferTo(dest);
            model.addAttribute("status", "success");
            model.addAttribute("msg", "아이템추가 성공했습니다");
            model.addAttribute("redirect", "/admin/adminItemManagementPage");
            return "alert";
        } catch (IOException e) {
            e.printStackTrace();
            return "파일 업로드 중 오류가 발생했습니다.";
        }

    }
}
