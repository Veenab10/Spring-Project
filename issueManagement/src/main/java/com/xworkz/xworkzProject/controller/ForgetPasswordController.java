package com.xworkz.xworkzProject.controller;

import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.service.ForgetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class ForgetPasswordController {

    @Autowired
    ForgetPasswordService forgetPasswordService;

    public ForgetPasswordController()
    {
        System.out.println("Created ForgetPasswordController");
    }

    @PostMapping("forgot-password")
    public String forgetPassword( @RequestParam String emailId, Model model)
    {
        System.out.println("Running forgetPassword method in ForgetPasswordController...");
        boolean success =forgetPasswordService.forgotPassword(emailId);
        if(success)
        {
            model.addAttribute("forgotMessage","A new Password has been sent to your emailId.");
        }
        else {
            model.addAttribute("forgotError","Email address not found.");
            return "ForgetPassword";
        }
       return "SignIn";
    }
}
