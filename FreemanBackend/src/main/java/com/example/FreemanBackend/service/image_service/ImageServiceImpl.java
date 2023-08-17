package com.example.FreemanBackend.service.image_service;

import com.example.FreemanBackend.model.ImageData;
import com.example.FreemanBackend.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public ImageData uploadImage(ImageData imageData) {
        return imageRepository.save(imageData);
    }

    @Override
    public List<ImageData> getAllImage() {
        return (List<ImageData>) imageRepository.findAll();
    }

    @Override
    public ImageData getImageById(long id) {
        if (imageRepository.findById(id).isPresent()) {
            return imageRepository.findById(id).get();
        }
        return null;
    }
}
