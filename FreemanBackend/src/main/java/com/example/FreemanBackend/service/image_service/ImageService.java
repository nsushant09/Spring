package com.example.FreemanBackend.service.image_service;

import com.example.FreemanBackend.model.ImageData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImageService {
    public ImageData uploadImage(ImageData imageData);

    public List<ImageData> getAllImage();

    public ImageData getImageById(long id);

}
