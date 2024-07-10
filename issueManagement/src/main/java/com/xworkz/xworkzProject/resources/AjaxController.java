package com.xworkz.xworkzProject.resources;

import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class AjaxController {
    public AjaxController()
    {
        System.out.println("Created AjaxController");
    }

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/validateEmail/{email}")
    public String validateEmail(@PathVariable("email") String emailId) {
        SignupDto dto = signUpService.findByEmail(emailId);
        System.out.println(emailId);
        System.out.println("dto"+dto);
        if(dto!=null) {

            return "Email already exists";
        }
        return "";
    }

    @GetMapping("/validatePhone/{phone}")
    public String validatePhone(@PathVariable("phone") Long contactNumber) {
        SignupDto dto = signUpService.findByPhone(contactNumber);
        System.out.println(contactNumber);
        System.out.println("dto"+dto);
        if(dto!=null) {

            return "Phone Number already exists";
        }
        return "";
    }
}
