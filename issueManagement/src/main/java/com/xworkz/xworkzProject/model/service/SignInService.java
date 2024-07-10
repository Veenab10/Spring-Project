package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.SignupDto;

public interface SignInService {

    //This findByEmailIDANdPassword is used for checking wheather id and pwd are exists in database or not
    SignupDto findByEmailIdAndPassword(String emailId,String password);


}
