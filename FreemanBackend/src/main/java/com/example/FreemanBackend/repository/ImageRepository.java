package com.example.FreemanBackend.repository;

import com.example.FreemanBackend.model.ImageData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<ImageData, Long> {
}
