package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.ProfileImageDto;
import com.xworkz.xworkzProject.model.repo.ProfileImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileImageServiceImpl implements ProfileImageService {

    @Autowired
    private ProfileImageRepo profileImageRepo;

    public ProfileImageServiceImpl()
    {
        System.out.println("Created ProfileImageServiceImpl");
    }

    @Override
    public boolean saveAndValidate(ProfileImageDto profileImageDto) {
        System.out.println("Running saveAndValidate method in ProfileImageServiceImpl");
        boolean save=profileImageRepo.save(profileImageDto);
        if(save)
        {
            System.out.println("saved in repo in service"+profileImageDto);
        }
        else {
            System.out.println("not saved in repo in service"+profileImageDto);
        }
        return true;
    }
}
