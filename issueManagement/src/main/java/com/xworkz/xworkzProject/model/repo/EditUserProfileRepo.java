package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.SignupDto;

public interface EditUserProfileRepo {
    default SignupDto findByEmailId(String emailId)
    {
        return  null;
    }

    SignupDto updateSignupDtoByEmailId(SignupDto updatedUserDetails);
}
