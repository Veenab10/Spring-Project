package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.repo.EditUserProfileRepo;
import com.xworkz.xworkzProject.model.repo.SignInRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    SignInRepo signInRepo;

    @Autowired
    private EditUserProfileRepo editUserProfileRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public SignInServiceImpl()
    {
        System.out.println("Created SignInServiceImpl");
    }

    //This findByEmailIDANdPassword is used for checking wheather id and pwd are exists in database or not and account lock
    @Override
    public SignupDto findByEmailIdAndPassword(String emailId, String password) {
        System.out.println(" this my service findByEmailIdAndPassword========================================");
          SignupDto signupDto=this.signInRepo.finByEmailId(emailId);
        System.out.println("service: data are exists"+signupDto);
        if(signupDto!=null && passwordEncoder.matches(password, signupDto.getPassword())  && !signupDto.isAccountLocked()) {
            System.out.println("service: data are exists" + signupDto);
            signupDto.setPassword(null);
            return signupDto;
        }

        System.out.println("service: data are not exists"+signupDto);
        return null;

    }
}


