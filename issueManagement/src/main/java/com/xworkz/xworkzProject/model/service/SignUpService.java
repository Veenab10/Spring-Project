package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.SignupDto;

import java.util.Optional;

public interface SignUpService {

    //saveAndValidate is used for Saving data into Database
    boolean saveAndValidate(SignupDto signupDto);

    // send method is used for sending password to email
    void sendPassword(SignupDto signupDto);

    //AJAX Call ( Checking Duplicate emailId and Contact Number using AJAX )

    Optional<SignupDto> validateEmail(String email);

    Optional<SignupDto> validatePhone(Long phone);

    SignupDto findByEmail(String emailId);

    SignupDto findByPhone(Long contactNumber);
}
