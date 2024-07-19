package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.SignupDto;

public interface ResetPasswordService {

    boolean changePassword(String email, String oldPassword, String newPassword, String confirmPassword);

   // void sendPassword(SignupDto signupDto);

}
