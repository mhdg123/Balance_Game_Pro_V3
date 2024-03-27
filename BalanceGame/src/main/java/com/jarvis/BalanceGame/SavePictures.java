package com.jarvis.BalanceGame;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SavePictures {

	public List<String> storeImages(List<MultipartFile> files, String realPath) throws IOException {
		List<String> fileNames = new ArrayList<>();

		String rootDir = realPath.replace("webapp\\", "");
		String uploadDir = rootDir + "resources/static/upload/";

		for (MultipartFile file : files) {
			if (file.getOriginalFilename() != "") {
				String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
				String filePath = uploadDir + fileName;
				File dest = new File(filePath);
				file.transferTo(dest);
				fileNames.add(fileName);
			}
		}

		return fileNames;
	}
	
	 public  boolean deleteImage(String fileName, String realPath) {
	        String rootDir = realPath.replace("webapp\\", "");
	        String uploadDir = rootDir + "resources/static/upload/";
	        String filePath = uploadDir + fileName;
	        
	        File file = new File(filePath);
	        
	        if (file.exists()) {
	            if (file.delete()) {
	                System.out.println("파일 삭제 성공: " + filePath);
	                return true;
	            } else {
	                System.out.println("파일 삭제 실패: " + filePath);
	                return false;
	            }
	        } else {
	            System.out.println("삭제할 파일이 존재하지 않습니다: " + filePath);
	            return false;
	        }
	    }
}