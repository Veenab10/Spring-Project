package com.xworkz.xworkzProject.controller;

import com.xworkz.xworkzProject.dto.AdminDto;
import com.xworkz.xworkzProject.dto.RaiseComplaintDto;
import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    public AdminController()
    {
        System.out.println("Created AdminController");
    }

    @PostMapping("/admin-signIn")
    public String adminProfile(@RequestParam("emailId") String adminEmailId,@RequestParam("password") String adminPassword, Model model)
    {
        System.out.println("Running adminProfile method in AdminController ");
        AdminDto adminDto=adminService.findByAdminEmailIdAndPassword(adminEmailId,adminPassword);
        if(adminDto!=null)
        {
            System.out.println("controller:Email ID and Passwords are exists"+"emailId"+adminEmailId+"password"+adminPassword);
            model.addAttribute("adminSuccess","SignIn Successfully");
            return "AdminProfile";

        }
        else {
            System.out.println("controller:Dto is not present"+"emailId"+adminEmailId+"password"+adminPassword);
            model.addAttribute("adminError","Failed to SignIn Successfully");
            return "AdminSignIn";
        }

    }

    //view user details
    @GetMapping("view-user-details")
    public String viewUserDetails(SignupDto signupDto, Model model) {
        System.out.println("viewUserDetails method in AdminController..");
        List<SignupDto> signUpDtoData = adminService.findByUSerId();

        if (signUpDtoData != null) {
            System.out.println("view-user-details successful in AdminController..");
            model.addAttribute("ViewUserDetails",signUpDtoData);
            System.out.println(signUpDtoData);
            return "AdminViewUserDetails";

        }
        else
        {
            System.out.println("view-user-details not  successful in AdminController..");
        }
        return "AdminViewUserDetails";
    }


@GetMapping("view-user-complaints")
public String viewUserComplaintDetails(RaiseComplaintDto raiseComplaintDto, Model model) {
    System.out.println("viewUserDetails method in AdminController..");
    List<RaiseComplaintDto> raiseComplaintDtos = adminService.findByUSerComplaintId();

    if (raiseComplaintDtos != null) {
        System.out.println("view-user-details successful in AdminController..");
        model.addAttribute("viewRaiseComplaints", raiseComplaintDtos);
        System.out.println(raiseComplaintDtos);
        return "AdminViewUserComplaintDetails";

    }
    else {
        System.out.println("view-user-details not  successful in AdminController..");
        return "AdminViewUserComplaintDetails";
    }


    }
    @GetMapping("search-user-complaints")
    public String searchUserComplaintDetails(RaiseComplaintDto raiseComplaintDto, Model model,String complaintType) {
        System.out.println("viewUserDetails method in AdminController..");
        List<RaiseComplaintDto> raiseComplaintDtos = adminService.findByUserComplaintType(complaintType);

        if (raiseComplaintDtos != null) {
            System.out.println("search-user-details successful in AdminController..");
            model.addAttribute("viewRaiseComplaints", raiseComplaintDtos);
            System.out.println(raiseComplaintDtos);
            return "AdminViewUserComplaintsSearchDetails";

        }
        else {
            System.out.println("search-user-details not  successful in AdminController..");
            return "AdminViewUserComplaintsSearchDetails";
        }


    }
}


