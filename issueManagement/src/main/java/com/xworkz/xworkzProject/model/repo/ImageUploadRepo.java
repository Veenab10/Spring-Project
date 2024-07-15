package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.ImageUploadDto;

import javax.transaction.Transactional;
import java.util.Optional;

public interface ImageUploadRepo {

    void saveProfileImage(ImageUploadDto imageUploadDto);

    Optional<ImageUploadDto> findByUserId(int id);


    @Transactional
    void setAllImagesInactiveForUser(int id);
}
