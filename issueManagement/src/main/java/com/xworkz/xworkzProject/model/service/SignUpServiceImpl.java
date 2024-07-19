package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.emailSending.MailSending;
import com.xworkz.xworkzProject.model.repo.SignUpRepo;
import com.xworkz.xworkzProject.util.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.xworkz.xworkzProject.util.PasswordGenerator.generatePassword;

@Service
public class SignUpServiceImpl  implements SignUpService{

    @Autowired
     private SignUpRepo signUpRepo;

    @Autowired
    private MailSending mailSending;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public SignUpServiceImpl()
    {
        System.out.println("Created SignUpServiceImpl");
    }

    //saving data into database
    @Override
    public boolean saveAndValidate(SignupDto signupDto) {
        System.out.println("Running saveAndValidate...");


        String fullName = signupDto.getFirstName() + " " + signupDto.getLastName();
        signupDto.setCreatedBy(fullName);
        signupDto.setCreateOn(LocalDateTime.now());

        signupDto.setImageName("defaultImage.jpeg");


        String password=generatePassword();
        signupDto.setPassword(passwordEncoder.encode(password));
        boolean save=signUpRepo.save(signupDto);
        if(save){
            signupDto.setPassword(password);
            //sendPassword(signupDto);
            mailSending.sendPassword(signupDto);
            return  true;
        }
        else {
            return  false;
        }
    }


    //Validating Email Id and Contact Number Using AJAX
    @Override
    public Optional<SignupDto> validateEmail(String email) {
        System.out.println("Running validateEmail in Service");
        long count = signUpRepo.countByEmail(email);
        if (count >= 1) {
            return Optional.of(new SignupDto());
        }
        return Optional.empty();
    }

    @Override
    public Optional<SignupDto> validatePhone(Long phone) {
        System.out.println("Running validatePhone in Service");
        long count = signUpRepo.countByPhone(phone);
        if (count >= 1) {
            return Optional.of(new SignupDto());
        }

        return Optional.empty();
    }

    @Override
    public SignupDto findByEmail(String emailId) {
        System.out.println("Running findByEmail in Service");
       return signUpRepo.findByEmail(emailId);
    }

    @Override
    public SignupDto findByPhone(Long contactNumber) {
        System.out.println("Running findByEmail in Service");
        return signUpRepo.findByPhone(contactNumber);
    }

}
