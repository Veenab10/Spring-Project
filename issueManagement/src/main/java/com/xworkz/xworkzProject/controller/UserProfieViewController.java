package com.xworkz.xworkzProject.controller;

import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.service.UserProfileViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
@SessionAttributes("signUpDTO")
public class UserProfieViewController {


    @Autowired
    private UserProfileViewService userProfileViewService;


    public UserProfieViewController() {

        System.out.println("Created UserProfieViewController");
    }

    @GetMapping("/view-profile")
    public String showProfile(Model model) {
        // Assuming you have a method to get the currently logged-in user's email
        String userEmail = userProfileViewService.getSignedInUserEmail();

        // Fetch user data based on the email
        SignupDto signupDto = userProfileViewService.getUserByEmail(userEmail);

        // Add the user data to the model
        model.addAttribute("signupDto", signupDto);

        // Return the view name
        return "SignupFormView";
    }

}


