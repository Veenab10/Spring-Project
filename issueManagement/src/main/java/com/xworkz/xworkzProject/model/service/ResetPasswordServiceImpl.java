package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.repo.ResetPasswordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static com.xworkz.xworkzProject.util.PasswordGenerator.generatePassword;

@Service
public class ResetPasswordServiceImpl implements ResetPasswordService {

    @Autowired
    private ResetPasswordRepo resetPasswordRepo;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public boolean changePassword(String emailId, String oldPassword, String newPassword,String confirmPassword) {
        SignupDto signupDto = resetPasswordRepo.findByEmailAndPassword(emailId, oldPassword);
        if (signupDto != null) {

            if (!newPassword.equals(confirmPassword)) {
                System.out.println("New password and confirm password do not match.");
                return false;
            }

            signupDto.setPassword(newPassword);
            resetPasswordRepo.updatePassword(emailId, newPassword);

          //signupDto.setPassword(newPassword);
            SimpleMailMessage message=new SimpleMailMessage();//SimpleMailMessage is a class
            message.setTo(emailId);
            message.setSubject("Password Reseting");
            message.setText("Your Reset password is:"+newPassword);
            javaMailSender.send(message);
            return true;


        }

        return false;
    }

    public void sendPassword(SignupDto signupDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(signupDto.getEmailId());
        message.setSubject("One Time Password");
        message.setText("Dear " + signupDto.getFirstName() + " " + signupDto.getLastName() + ", You have been successfully Signed Up,\n\n" +
                "Please Sign in through this password: " + signupDto.getPassword() + "\n\n" +
                "Thanks and Regards,\n" + " " +
                "XworkzProject Team");
        javaMailSender.send(message);
    }
}


//    @Override
//    public void sendChangePasswordToEmail(String toEmail) {
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setTo(toEmail);
//        simpleMailMessage.setSubject("Password Changed");
//        simpleMailMessage.setText("Your password has been successfully changed.");
//        simpleMailMessage.setFrom("pruthvik1014@gmail.com");
//        javaMailSender.send(simpleMailMessage);
//    }
//}

