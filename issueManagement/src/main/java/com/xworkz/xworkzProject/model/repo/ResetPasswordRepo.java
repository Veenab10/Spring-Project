package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.SignupDto;

public interface ResetPasswordRepo {

    SignupDto findByEmailAndPassword(String emailId, String password);

    boolean updatePassword(String emailId, String newPassword);
}
