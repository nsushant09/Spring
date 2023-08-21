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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @Value("${user.dir}/uploads")
    private String uploadDirectory;

//    @GetMapping("/{id}")
//    public ResponseEntity<byte[]> displayImageById(@PathVariable long id) throws IOException, SQLException {
//        ImageData image = imageService.getImageById(id);
//        byte[] imageBytes = null;
//        imageBytes = image.getImage().getBytes(1, (int) image.getImage().length());
//        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
//    }

    @PostMapping("/upload")
    public ResponseEntity<ImageData> uploadImage(HttpServletRequest request, @RequestParam("image") MultipartFile file) throws IOException, SerialException, SQLException {
        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        ImageData image = new ImageData();
        image.setImage(blob);
        ImageData uploadedImage = imageService.uploadImage(image);
        return ResponseEntity.ok().body(uploadedImage);
    }

    @PostMapping("/")
    public ResponseEntity<String> uploadImageToPath(HttpServletRequest request, @RequestParam("image") MultipartFile file) throws IOException, SerialException, SQLException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload.");
        }

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String filePath = uploadDirectory + "/" + fileName;

        try (OutputStream outputStream = new FileOutputStream(filePath)) {
            outputStream.write(file.getBytes());
        }

        return ResponseEntity.ok().body(getFullImageUrl(request, fileName));
    }

    private byte[] convertImageToBytes(ImageData imageData) {
        try {
            return imageData.getImage().getBytes(1, (int) imageData.getImage().length());
        } catch (SQLException ignored) {
            return null;
        }
    }
    private String getFullImageUrl(HttpServletRequest request, String imageName) {
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int portNumber = request.getServerPort();
        String contextPath = request.getContextPath();

        return scheme + "://" + serverName + ":" + portNumber + contextPath + "/image/" + imageName;
    }

    @GetMapping("/{imageName}")
    public ResponseEntity<FileSystemResource> getImage(@PathVariable String imageName) throws IOException {
        String filePath = uploadDirectory + "/" + imageName;

        File imageFile = new File(filePath);
        if (!imageFile.exists()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new FileSystemResource(imageFile));
    }
}