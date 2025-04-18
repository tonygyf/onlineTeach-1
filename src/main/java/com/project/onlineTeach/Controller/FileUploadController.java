package com.project.onlineTeach.Controller;

import com.project.onlineTeach.Util.AliOssUtil;
import com.project.onlineTeach.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
public class FileUploadController {

    @PostMapping ("/upload")
    public Result<String>upload(MultipartFile file) throws Exception {
      String originalFilename= file.getOriginalFilename();
        String fileName= UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
       String url=  AliOssUtil.uploadFile(fileName,file.getInputStream());
        return Result.success(url);


    }


}
