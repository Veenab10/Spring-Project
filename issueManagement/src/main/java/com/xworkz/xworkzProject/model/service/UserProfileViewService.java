package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.SignupDto;

public interface UserProfileViewService {


    SignupDto getUserByEmail(String emailId);

    String getSignedInUserEmail();
}
