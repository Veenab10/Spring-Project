package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.ImageUploadDto;

import java.util.Optional;

public interface ImageUploadService {

    Optional<ImageUploadDto> getImageDetailsByUserId(int id);
}
