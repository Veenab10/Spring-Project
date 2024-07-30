package com.xworkz.xworkzProject.emailSending;

import com.xworkz.xworkzProject.dto.DepartmentAdminDto;
import com.xworkz.xworkzProject.dto.SignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSending {

    @Autowired
    private JavaMailSender javaMailSender;

    public MailSending()
    {
        System.out.println("Created MailSending ");
    }

    public void sendPassword(SignupDto signupDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(signupDto.getEmailId());
        message.setSubject("SignIn password");
        message.setText("Dear " + signupDto.getFirstName() + " " + signupDto.getLastName() + ", You have been successfully Signed Up,\n\n" +
                "Please Sign in through this password: " + signupDto.getPassword() + "\n\n" +
                "Thanks and Regards,\n" + " " +
                "XworkzProject Team");
        javaMailSender.send(message);
    }

    public void forgotPassword(SignupDto signupDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(signupDto.getEmailId());
        message.setSubject("Forgot password");
        message.setText("Dear " + signupDto.getFirstName() + " " + signupDto.getLastName() + ",Your forgot password is,\n\n" +signupDto.getPassword()+"\n"+
                "Please Sign in through this password: "+ "\n\n" +
                "Thanks and Regards,\n" + " " +
                "XworkzProject Team");
        javaMailSender.send(message);
    }


    public void sendResetPassword(SignupDto signupDto, String newPassword) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(signupDto.getEmailId());
        message.setSubject("Changed Password");
        message.setText("Dear " + signupDto.getFirstName() + " " + signupDto.getLastName() + ",Your changed password is,\n\n" +newPassword+"\n"+
                "Please Sign in through this password: "+ "\n\n" +
                "Thanks and Regards,\n" + " " +
                "XworkzProject Team");
        javaMailSender.send(message);
    }


//    public void sendDepartmentPassword(DepartmentAdminDto departmentAdminDto) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(departmentAdminDto.getDepartmentAdminEmailId());
//        message.setSubject("Department Admin Password");
//        message.setText("Dear " + departmentAdminDto.getDepartmentAdminName() + " "  + ",Your Department admin password is,\n\n" +
//                "Please Sign in through this password: "+ "\n\n" +departmentAdminDto.getDepartmentAdminPassword()+"\n\n"+
//                "Thanks and Regards,\n" + " " +
//                "XworkzProject Team");
//        javaMailSender.send(message);
//    }

    public void sendDepartmentPassword(DepartmentAdminDto departmentAdminDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(departmentAdminDto.getDepartmentAdminEmailId());
        message.setSubject("Department Admin password");
        message.setText("Dear " + departmentAdminDto.getDepartmentAdminName() + " " +  ", You have been successfully Signed Up,\n\n" +
                "Please Sign in through this password: " + departmentAdminDto.getDepartmentAdminPassword() + "\n\n" +
                "Thanks and Regards,\n" + " " +
                "XworkzProject Team");
        javaMailSender.send(message);
    }




}
