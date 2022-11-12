package com.example.demo.src.upload;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class UploadController {
    private final UploadService uploadService;

    @PostMapping("/upload")
    public BaseResponse<String> uploadFile(@RequestParam("images")MultipartFile multipartFile) throws IOException {
        String result = uploadService.upload(multipartFile);

        return new BaseResponse<>(result);
    }
    }