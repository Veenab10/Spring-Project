package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.ProfileImageDto;

public interface ProfileImageService {

    boolean saveAndValidate(ProfileImageDto profileImageDto);
}
