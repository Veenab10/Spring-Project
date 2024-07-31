package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.repo.EditUserProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Service
public class EditUserProfileServiceImpl implements EditUserProfileService {

    @Autowired
    private EditUserProfileRepo editUserProfileRepo;

    @Autowired
    private HttpSession httpSession;

    public EditUserProfileServiceImpl()
    {
        System.out.println("Created EditUserProfileServiceImpl");
    }

    @Override
    public SignupDto findByEmailId(String emailId){
        System.out.println("running findByID  method in CountryServiceImpl.. ");

        SignupDto res=editUserProfileRepo.findByEmailId(emailId);

        if(res!=null)
        {
            System.out.println("searched result in service");
            return res;
        }
        else {
            System.out.println("not searched result in service");
        }
        return EditUserProfileService.super.findByEmailId(emailId);
    }


    @Override
    public SignupDto updateSignupDtoByEmailId(SignupDto dto) {
        System.out.println("Running updateSignupDtoByEmailId method in EditUserProfileServiceImpl ");


        //AuditDto
        String fullName = dto.getFirstName() + " " + dto.getLastName();
        dto.setUpdatedBy(fullName);
        dto.setUpdatedOn(LocalDateTime.now());

        dto.setCount(0);

        SignupDto existingUser = editUserProfileRepo.findByEmailId(dto.getEmailId());
        httpSession.getAttribute("signedInUserEmail");
        if (existingUser != null) {
            existingUser.setFirstName(dto.getFirstName());
            existingUser.setLastName(dto.getLastName());
            existingUser.setContactNumber(dto.getContactNumber());
            existingUser.setAlternativeContactNumber(dto.getAlternativeContactNumber());
            existingUser.setAddress(dto.getAddress());
            existingUser.setImageName(dto.getImageName());
            existingUser.setUpdatedBy(dto.getUpdatedBy());
            existingUser.setUpdatedOn(dto.getUpdatedOn());
            //existingUser.setAgree(dto.getAgree());

            return editUserProfileRepo.updateSignupDtoByEmailId(existingUser); // Pass the updated user details to the repo method
        }
        return null;
    }
}

