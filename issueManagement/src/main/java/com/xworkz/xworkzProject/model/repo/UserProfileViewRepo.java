package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.SignupDto;

public interface UserProfileViewRepo {

    SignupDto findByEmailId(String emailId);
}
