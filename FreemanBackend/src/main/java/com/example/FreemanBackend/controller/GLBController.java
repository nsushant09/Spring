package com.example.FreemanBackend.controller;

import com.example.FreemanBackend.model.ImageData;
import com.example.FreemanBackend.service.image_service.ImageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.rowset.serial.SerialException;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/glb")
public class GLBController {
    @Autowired
    private ImageService imageService;

    @Value("${user.home}/glbUploads")
    private String uploadDirectory;



    @PostMapping("/")
    public ResponseEntity<String> uploadFileToPath(HttpServletRequest request, @RequestParam("glbFile") MultipartFile file) throws IOException, SerialException, SQLException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload.");
        }

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String filePath = uploadDirectory + "/" + fileName;

        try (OutputStream outputStream = new FileOutputStream(filePath)) {
            outputStream.write(file.getBytes());
        }

        return ResponseEntity.ok().body(getFullUrl(request, fileName));
    }

    private String getFullUrl(HttpServletRequest request, String imageName) {
        return "/image/" + imageName;
    }

    @GetMapping("/{filename}")
    public ResponseEntity<FileSystemResource> getImage(@PathVariable String filename) throws IOException {
        String filePath = uploadDirectory + "/" + filename;

        File imageFile = new File(filePath);
        if (!imageFile.exists()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType("model/gltf-binary"))
                .body(new FileSystemResource(imageFile));
    }

}
