package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.SignupDto;

public interface SignInRepo {

     SignupDto finByEmailId(String email);
    //This findByEmailIDANdPassword is used for checking wheather id and pwd are exists in database or not
    SignupDto findByEmailIdAndPassword(String emailId,String password);
}
