package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.repo.UserProfileViewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserProfileViewServiceImpl implements UserProfileViewService {

    @Autowired
    private UserProfileViewRepo userProfileViewRepo;

    @Autowired
    private HttpSession httpSession;

    public UserProfileViewServiceImpl()
    {
        System.out.println("Created UserProfileViewServiceImpl ");
    }



    @Override
    public SignupDto getUserByEmail(String emailId) {
        return userProfileViewRepo.findByEmailId(emailId);
    }

    @Override
    public String getSignedInUserEmail() {

        return (String)httpSession.getAttribute("signedInUserEmail") ;
    }
}
