package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.SignupDto;

public interface ForgetPasswordRepo {

    SignupDto findByEmailId(String emailId );

    void updatePassword(String emailId,String password );
}
