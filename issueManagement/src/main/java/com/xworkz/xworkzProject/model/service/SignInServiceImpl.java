package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.repo.SignInRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    SignInRepo signInRepo;

    public SignInServiceImpl()
    {
        System.out.println("Created SignInServiceImpl");
    }

    //This findByEmailIDANdPassword is used for checking wheather id and pwd are exists in database or not and account lock
    @Override
    public SignupDto findByEmailIdAndPassword(String emailId, String password) {
        SignupDto signupDto=signInRepo.findByEmailIdAndPassword(emailId,password);
        if(signupDto!=null && signupDto.getPassword().equals(password) && !signupDto.isAccountLocked())
        {
            System.out.println("service: data are exists"+signupDto);
        }
        else {
            System.out.println("service: data are not exists"+signupDto);
        }
        return signupDto;
    }
}


