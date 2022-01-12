package com.github.pedroluiznogueira.vehiclecatalogapi.controller;

import com.github.pedroluiznogueira.vehiclecatalogapi.service.AmazonS3BucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class S3BucketController {

    @Autowired
    private AmazonS3BucketService amazonS3BucketService;

    S3BucketController(AmazonS3BucketService amazonS3BucketService) {
        this.amazonS3BucketService = amazonS3BucketService;
    }

    @PostMapping("/upload-file")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonS3BucketService.uploadFile(file);
    }

    @PostMapping("/delete-file")
    public String deleteFile(@RequestBody String fileURL) {
        return this.amazonS3BucketService.deleteFileFromBucket(fileURL);
    }
}
