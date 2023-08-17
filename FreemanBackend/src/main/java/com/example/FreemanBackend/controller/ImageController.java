package com.example.FreemanBackend.controller;

import com.example.FreemanBackend.model.ImageData;
import com.example.FreemanBackend.service.image_service.ImageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> displayImageById(@PathVariable long id) throws IOException, SQLException {
        ImageData image = imageService.getImageById(id);
        byte[] imageBytes = null;
        imageBytes = image.getImage().getBytes(1, (int) image.getImage().length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }

    @GetMapping("/all")
    public ResponseEntity<List<byte[]>> getAllImage() {
        List<ImageData> imageList = imageService.getAllImage();
        List<byte[]> imageBytesList = new ArrayList<>();

        for (ImageData image : imageList) {
            byte[] bytes = convertImageToBytes(image);
            if (bytes != null)
                imageBytesList.add(bytes);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(imageBytesList, headers, HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<ImageData> uploadImage(HttpServletRequest request, @RequestParam("image") MultipartFile file) throws IOException, SerialException, SQLException {
        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        ImageData image = new ImageData();
        image.setImage(blob);
        ImageData uploadedImage = imageService.uploadImage(image);
        return ResponseEntity.ok().body(uploadedImage);
    }

    private byte[] convertImageToBytes(ImageData imageData) {
        try {
            return imageData.getImage().getBytes(1, (int) imageData.getImage().length());
        } catch (SQLException ignored) {
            return null;
        }
    }
}