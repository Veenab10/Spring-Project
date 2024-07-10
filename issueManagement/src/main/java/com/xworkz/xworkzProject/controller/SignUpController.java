package com.xworkz.xworkzProject.controller;

import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @Autowired
    private HttpSession httpSession;

    public SignUpController()
    {
        System.out.println("Created SignUpController");
    }

    @PostMapping("/signup")
    public String signup(@Valid SignupDto signupDto, Model model)
    {
        System.out.println("Running signup method in SignUpController ");
        boolean saved=signUpService.saveAndValidate(signupDto);
        if(saved)
        {
            httpSession.setAttribute("signedInUserEmail",signupDto);
            System.out.println("saved  service in controller"+signupDto);
        }
        else {
            System.out.println("not saved service in controller"+signupDto);
        }
        model.addAttribute("result","Successfully Registered by:"+signupDto.getFirstName()+signupDto.getLastName());

        return "Signup";
    }


}
