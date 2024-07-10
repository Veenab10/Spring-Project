package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.SignupDto;

public interface EditUserProfileService {

    default SignupDto findByEmailId(String emailId)
    {
        return  null;
    }

    //void updateSignupDtoByEmailId(String emailId,SignupDto updatedSignupDto);

    SignupDto updateSignupDtoByEmailId(SignupDto dto);
}
