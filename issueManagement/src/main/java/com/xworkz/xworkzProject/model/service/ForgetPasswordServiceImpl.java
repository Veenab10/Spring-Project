package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.emailSending.MailSending;
import com.xworkz.xworkzProject.model.repo.ForgetPasswordRepo;
import com.xworkz.xworkzProject.util.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.xworkz.xworkzProject.util.PasswordGenerator.generatePassword;

@Service
public class ForgetPasswordServiceImpl implements ForgetPasswordService {

    @Autowired
    private ForgetPasswordRepo forgetPasswordRepo;

    @Autowired
    private AccountLockService accountLockService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private MailSending mailSending;

    public ForgetPasswordServiceImpl()
    {
        System.out.println("Created ForgetPasswordServiceImpl");
    }

    @Override
    public boolean forgotPassword(String emailId) {
        System.out.println("Running forgotPassword in ForgetPasswordServiceImpl.. ");
        SignupDto signupDto=forgetPasswordRepo.findByEmailId(emailId);
        if(signupDto!=null)
        {
            //Generating Random password and sending it...
            String newPassword = generatePassword();
           // signupDto.setPassword(encoder.encode(newPassword));
            forgetPasswordRepo.updatePassword(emailId,encoder.encode(newPassword));
            signupDto.setPassword(newPassword);
            //sendPassword(signupDto);
            mailSending.forgotPassword(signupDto);

            //Reset failed attempts
            accountLockService.resetFailedAttempts(emailId);
            accountLockService.unlockAccount(emailId);
            System.out.println("(service)Data is existing "+signupDto);

            return true;

        }
        else
        {
            System.out.println("(service) Data is not existing"+signupDto);
        }
        return false;
    }

}
