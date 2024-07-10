package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.SignupDto;

import java.util.Optional;

public interface SignUpRepo {

    //saving fields values into database
    boolean save(SignupDto signupDto);

    //counting Email Id and Contact which exists in the database (AJAX)
    long countByEmail(String email);

    long countByPhone(Long phone);

    SignupDto findByEmail(String emailId);

    SignupDto findByPhone(Long contactNumber);

    //Optional<SignupDto> findById(int id);
}
