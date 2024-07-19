package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.SignupDto;

public interface ForgetPasswordService {
    boolean forgotPassword(String emailId);

}
