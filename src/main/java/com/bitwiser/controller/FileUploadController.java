package com.bitwiser.controller;

import com.bitwiser.service.CloudinaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
@CrossOrigin
public class FileUploadController {

    private final CloudinaryService cloudinaryService;

    public FileUploadController(
            CloudinaryService cloudinaryService
    ) {
        this.cloudinaryService = cloudinaryService;
    }

    @PostMapping("/project-image")
    public ResponseEntity<String> uploadImage(
            @RequestParam("file") MultipartFile file
    ) {

        try {

            String imageUrl =
                    cloudinaryService.uploadFile(file);

            return ResponseEntity.ok(imageUrl);

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.badRequest()
                    .body(e.getMessage());

        }
    }
}