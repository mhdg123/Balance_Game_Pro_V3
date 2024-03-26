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
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            String filePath = uploadDir + fileName;
            File dest = new File(filePath);
            file.transferTo(dest);
            fileNames.add(fileName);
        }

        return fileNames;
    }
}