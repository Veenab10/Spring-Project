package com.xworkz.xworkzProject.controller;

import com.xworkz.xworkzProject.dto.RaiseComplaintDto;
import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.service.RaiseComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

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
            return "ViewComplaint";
        }

        else {
            model.addAttribute("ErrorRaiseComplaintSucess"," Not saved raiseComplaint details successfully");
            System.out.println("Controller:not save raiseComplaint details successfully"+raiseComplaintDto);
        }
        return "RaiseComplaint";
    }

    @GetMapping("view-complaint")
    public String viewComplaint(@RequestParam("complaintId")int complaintId,HttpServletRequest request, Model model) {
        System.out.println("Running viewComplaint method in RaiseComplaintController...");

        // Step 1: Retrieve signed-in user email
        HttpSession httpSession = request.getSession();
        RaiseComplaintDto raiseComplaintDto = (RaiseComplaintDto) httpSession.getAttribute("raiseComplaintDto");
        Integer cid = raiseComplaintDto != null ? raiseComplaintDto.getComplaintId() : null;

        // Step 2: Retrieve complaint DTO based on complaint ID (assuming complaintId is obtained somehow)
        //int complaintId = raiseComplaintDto.getComplaintId(); // You need to define how you get the complaintId
        RaiseComplaintDto raiseComplaintDto1 = raiseComplaintService.findByComplaintId(complaintId);

        // Step 3: Add the complaint DTO to the model
        model.addAttribute("raiseComplaintDto", raiseComplaintDto);

        // Step 4: Return the view name
        return "ViewComplaint"; // Assuming "ComplaintView" is your view name
    }

    @GetMapping("edit-complaint")
    public String editComplaint(@RequestParam("complaintId")int complaintId)
    {
        System.out.println("Running editComplaint running in RaiseComplaintController ");
        RaiseComplaintDto raiseComplaintDto1 = raiseComplaintService.findByComplaintId(complaintId);

        return "EditRaiseComplaint";
    }

}
