package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.SignupDto;

public interface AccountLockRepo {

    SignupDto findByEmailId(String emailId );

    boolean update(SignupDto signupDto);
}
