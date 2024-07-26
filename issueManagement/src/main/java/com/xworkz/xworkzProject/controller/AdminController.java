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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    public AdminController() {
        System.out.println("Created AdminController");
    }

    @PostMapping("/admin-signIn")
    public String adminProfile(@RequestParam("emailId") String adminEmailId, @RequestParam("password") String adminPassword, Model model) {
        System.out.println("Running adminProfile method in AdminController ");
        AdminDto adminDto = adminService.findByAdminEmailIdAndPassword(adminEmailId, adminPassword);
        if (adminDto != null) {
            System.out.println("controller:Email ID and Passwords are exists" + "emailId" + adminEmailId + "password" + adminPassword);
            model.addAttribute("adminSuccess", "SignIn Successfully");
            return "AdminProfile";

        } else {
            System.out.println("controller:Dto is not present" + "emailId" + adminEmailId + "password" + adminPassword);
            model.addAttribute("adminError", "Failed to SignIn Successfully");
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
            model.addAttribute("ViewUserDetails", signUpDtoData);
            System.out.println(signUpDtoData);
            return "AdminViewUserDetails";

        } else {
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

        } else {
            System.out.println("view-user-details not  successful in AdminController..");
            return "AdminViewUserComplaintDetails";
        }

    }

    @PostMapping("/search-user-complaints")
    public String searchUserComplaintDetails(RaiseComplaintDto raiseComplaintDto, Model model) {
        System.out.println("viewUserDetails method in AdminController..");

        List<RaiseComplaintDto> listOfComplaintTypeAndCity = adminService.searchByUserComplaintTypeAndCity(raiseComplaintDto.getComplaintType(), raiseComplaintDto.getCity());
        if (!listOfComplaintTypeAndCity.isEmpty()) {
            model.addAttribute("listOfComplaintType", listOfComplaintTypeAndCity);
            return "AdminViewUserComplaintDetails";
        }
        else {
            List<RaiseComplaintDto> listOfComplaintTypeOrCity = adminService.searchByUserComplaintTypeOrCity(raiseComplaintDto.getComplaintType(), raiseComplaintDto.getCity());
            if (!listOfComplaintTypeOrCity.isEmpty()) {
                model.addAttribute("listOfComplaintType", listOfComplaintTypeOrCity);
                return "AdminViewUserComplaintDetails";
            }
        }

        return "AdminViewUserComplaintDetails";
    }

//    @PostMapping("/search-user-complaints")
//    public String searchUserComplaintDetails(RaiseComplaintDto raiseComplaintDto, Model model) {
//        System.out.println("viewUserDetails method in AdminController..");
//        List<RaiseComplaintDto> listOfComplaintType = adminService.searchByComplaintType(raiseComplaintDto.getComplaintType());
//
//        List<RaiseComplaintDto> listOfComplaintTypeAndCity = adminService.searchByUserComplaintTypeAndCity(raiseComplaintDto.getComplaintType(), raiseComplaintDto.getCity());
//        if (!listOfComplaintTypeAndCity.isEmpty()) {
//            model.addAttribute("listOfComplaintType", listOfComplaintTypeAndCity);
//            return "AdminViewUserComplaintDetails";
//        }
//
//        else if (!listOfComplaintType.isEmpty()) {
//                model.addAttribute("listOfComplaintType", listOfComplaintType);
//                return "AdminViewUserComplaintDetails";
//            }
//
//        else {
//            List<RaiseComplaintDto> listOfCity = adminService.searchByCity(raiseComplaintDto.getCity());
//            if (!listOfCity.isEmpty()) {
//                System.out.println("Running city...");
//                model.addAttribute("listOfComplaintType", listOfCity);
//                return "AdminViewUserComplaintDetails";
//            }
//        }
//
//        return "AdminViewUserComplaintDetails";
//    }
}


