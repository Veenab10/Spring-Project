package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.ImageUploadDto;
import com.xworkz.xworkzProject.model.repo.ImageUploadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {

    @Autowired
    private ImageUploadRepo imageUploadRepo;

    public ImageUploadServiceImpl()
    {
        System.out.println("Created ImageUploadServiceImpl");
    }

    @Override
    public Optional<ImageUploadDto> getImageDetailsByUserId(int id) {
        return imageUploadRepo.findByUserId(id);
    }


}
