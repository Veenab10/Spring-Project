package com.xworkz.xworkzProject.controller;

import com.xworkz.xworkzProject.dto.RaiseComplaintDto;
import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.service.RaiseComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
@SessionAttributes("signupDto")
public class RaiseComplaintController {

    @Autowired
    private RaiseComplaintService raiseComplaintService;

    public RaiseComplaintController()
    {
        System.out.println("Created RaiseComplaintController");
    }

    @PostMapping("/raise-complaint")
    public String raiseComplaint(@ModelAttribute("signupDto") SignupDto signupDto,@ModelAttribute("raiseComplaintDto") RaiseComplaintDto raiseComplaintDto, Model model)
    {
        System.out.println("Running raiseComplaint method in RaiseComplaintController...");
        // Accessing id from SignupDto
        int signedInUserId = signupDto.getId();
        System.out.println("Signed in user ID: " + signedInUserId);

        // Set the signed in user ID in raiseComplaintDto
        SignupDto userDto = new SignupDto();
        userDto.setId(signedInUserId);
        raiseComplaintDto.setUserId(userDto);

        boolean save=raiseComplaintService.saveRaiseComplaintType(raiseComplaintDto);


        if(save)
        {
            System.out.println("Controller:save raiseComplaint details successfully"+raiseComplaintDto);
            model.addAttribute("raiseComplaintSucess","saved raiseComplaint details successfully");
            return "RaiseComplaint";
        }

        else {
            model.addAttribute("ErrorRaiseComplaintSucess"," Not saved raiseComplaint details successfully");
            System.out.println("Controller:not save raiseComplaint details successfully"+raiseComplaintDto);
        }
        return "RaiseComplaint";
    }
}
