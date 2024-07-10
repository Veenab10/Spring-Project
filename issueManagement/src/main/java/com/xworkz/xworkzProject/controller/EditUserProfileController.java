package com.xworkz.xworkzProject.controller;

import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.service.EditUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
@SessionAttributes("signupDto") // Specify the model attribute to be stored in session
public class EditUserProfileController {

    @Autowired
    private EditUserProfileService editUserProfileService;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/edit-profile")
    public String showUserDetails(Model model) {
        String userEmail = (String) httpSession.getAttribute("signedInUserEmail");
        System.out.println("Signed-in user email: " + userEmail);

        if (userEmail != null) {
            SignupDto dto = (SignupDto) model.getAttribute("signupDto"); // Retrieve from model
            if (dto == null) {
                // If signupDto is not in session, fetch it from service (though ideally, it should be set during sign-in)
                dto = editUserProfileService.findByEmailId(userEmail);
                model.addAttribute("signupDto", dto); // Add to model for session attributes
            }
            model.addAttribute("signupdto", dto); // Make sure the attribute name matches what is used in JSP
        } else {
            System.out.println("User email not found in session.");
            // Handle session expired or not signed in
        }

        return "EditUserProfile"; // Return the name of your JSP file
    }

    // Add update profile functionality if required


    @PostMapping("/edit-profile")
    public String editUser(SignupDto signupDto, Model model) {
        SignupDto updatedUser = editUserProfileService.updateSignupDtoByEmailId(signupDto);
        if (updatedUser != null) {
            // model.addAttribute("signupDto", updatedUser);
            model.addAttribute("signupDto", updatedUser);
            model.addAttribute("profileMessage", "Profile updated successfully");
            return "EditUserProfile";
        }
        model.addAttribute("profileError", "Error updating profile");
        return "HomePage";
    }
}


