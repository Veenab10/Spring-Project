package com.xworkz.xworkzProject.controller;

import com.xworkz.xworkzProject.dto.RaiseComplaintDto;
import com.xworkz.xworkzProject.model.service.RaiseComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class RaiseComplaintController {

    @Autowired
    private RaiseComplaintService raiseComplaintService;

    public RaiseComplaintController()
    {
        System.out.println("Created RaiseComplaintController");
    }

    @PostMapping("/raise-complaint")
    public String raiseComplaint(RaiseComplaintDto raiseComplaintDto)
    {
        System.out.println("Running raiseComplaint method in RaiseComplaintController...");
        boolean save=raiseComplaintService.saveRaiseComplaintType(raiseComplaintDto);
        if(save)
        {
            System.out.println("Controller:save raiseComplaint details successfully"+raiseComplaintDto);
        }

        else {
            System.out.println("Controller:not save raiseComplaint details successfully"+raiseComplaintDto);
        }
        return "RaiseComplaint";
    }
}
