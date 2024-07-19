package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.emailSending.MailSending;
import com.xworkz.xworkzProject.model.repo.ResetPasswordRepo;
import com.xworkz.xworkzProject.model.repo.SignInRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.xworkz.xworkzProject.util.PasswordGenerator.generatePassword;

@Service
public class ResetPasswordServiceImpl implements ResetPasswordService {

    @Autowired
    private ResetPasswordRepo resetPasswordRepo;

    @Autowired
    private MailSending mailSending;

    @Autowired
    private SignInRepo signInRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean changePassword(String emailId, String oldPassword, String newPassword, String confirmPassword) {
          System.out.println("Attempting to change password for email: " + emailId);

        // Step 1: Check if newPassword matches confirmPassword
        if (!newPassword.equals(confirmPassword)) {
            System.out.println("New password and confirm password do not match.");
            return false;
        }

        // Step 2: Retrieve SignupDto based on emailId
        SignupDto signupDto = this.signInRepo.finByEmailId(emailId);
        if (signupDto == null) {
            System.out.println("User with email " + emailId + " not found.");
            return false; // User not found
        }
         String storedPassword=signupDto.getPassword();
        System.out.println(storedPassword);
        // Step 3: Verify oldPassword matches the stored password
        if (!passwordEncoder.matches(oldPassword, storedPassword)){
            System.out.println("Old password verification failed for email: " + emailId);
            return false; // Old password doesn't match
        }

        // Step 4: Encode and update the new password in SignupDto
        signupDto.setPassword(passwordEncoder.encode(newPassword));

        // Step 5: Save the updated password in the repository
        boolean save = resetPasswordRepo.updatePassword(emailId, signupDto.getPassword());

        // Step 6: Send email notification if password update was successful
        if (save) {
            System.out.println("Password updated successfully for email: " + emailId);
            try {
                mailSending.sendResetPassword(signupDto, newPassword);
                return true; // Password successfully updated and email sent
            } catch (MailException e) {
                // Handle exception if email sending fails (log it or take appropriate action)
                e.printStackTrace();
                return false; // Indicate failure if email sending failed
            }
        }

        return false; // Password update failed
    }
}



