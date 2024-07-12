package com.xworkz.xworkzProject.controller;

import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.service.AccountLockService;
import com.xworkz.xworkzProject.model.service.SignInService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("")
public class SignInController {

    private static final Logger log = LoggerFactory.getLogger(SignInController.class);
    @Autowired
    SignInService signInService;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    AccountLockService accountLockService;

    public SignInController() {
        System.out.println("Created SignInController");
        log.info("Created SignInController");
    }

    @GetMapping("/signIn")
    public String signIn() {
        System.out.println("Running signIn method....");
        return "SignIn";
    }

    // signInSubmit method for login
    @PostMapping("/signIn")
    public String signInSubmit(@Valid Model model, @RequestParam String emailId, @RequestParam String password) {
        System.out.println("Running signInSubmit method....");
        SignupDto signupDto = signInService.findByEmailIdAndPassword(emailId, password);
        if (signupDto != null && !signupDto.isAccountLocked()) {
            accountLockService.resetFailedAttempts(emailId);
            model.addAttribute("Loginresult", "Login Succcessfully with," + signupDto.getEmailId());
            System.out.println("(Controller) data are exists" + signupDto);

            // Set session for email
            httpSession.setAttribute("signedInUserEmail", emailId);

            // Set  session for signupDto
            httpSession.setAttribute("signupDto", signupDto);

            //Set the profile image in the session
            String profileImageUrl = "/images/" + signupDto.getImageName();
            httpSession.setAttribute("profileImage", profileImageUrl);

        } else {
            accountLockService.incrementFailedAttempts(emailId);
            int failedAttempts = accountLockService.getFailedAttempts(emailId);
            System.out.println("Failed attempts for " + emailId + ": " + failedAttempts);
            if (failedAttempts >= 3) {
                accountLockService.lockAccount(emailId); // Lock account after 3 failed attempts
                model.addAttribute("error", "Your account is locked due to too many failed attempts.");
                model.addAttribute("accountLocked", true);
                return "SignIn";
            } else {
                model.addAttribute("failed", "Invalid email id and password. Attempts: " + failedAttempts);
                model.addAttribute("accountLocked", false);
                System.out.println("(Controller) data are not exists" + signupDto);

            }
        }

        return "HomePage";
    }
}
