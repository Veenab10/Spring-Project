package com.xworkz.xworkzProject.controller;

import com.xworkz.xworkzProject.dto.*;
import com.xworkz.xworkzProject.model.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
    public String viewUserComplaintDetails(RaiseComplaintDto raiseComplaintDto, Model model, DepartmentDto departmentDto) {
        System.out.println("viewUserDetails method in AdminController..");
        List<RaiseComplaintDto> viewRaiseComplaints = adminService.findByUSerComplaintId();
        List<DepartmentDto> departments = adminService.getAllDepartments(); // Retrieve department names


        if (!viewRaiseComplaints.isEmpty()) {
            System.out.println("view-user-details successful in AdminController..");
            model.addAttribute("viewRaiseComplaints", viewRaiseComplaints);
            model.addAttribute("departments", departments);
            System.out.println(viewRaiseComplaints);
            return "AdminViewUserComplaintDetails";


        } else {
            System.out.println("view-user-details not  successful in AdminController..");
            return "AdminViewUserComplaintDetails";

        }

    }

    @PostMapping("/allocate-department")
    public String allocateDepartment(
            @RequestParam("complaintId") Long complaintId,
            @RequestParam("departmentId") Long departmentId,
            @RequestParam("status") String status,
            Model model
    ) {
        try {
            System.out.println("Running allocate department");

            // Call the service method to allocate department
            adminService.allocateDepartment(complaintId, departmentId, status);
            System.out.println("complaintId" + complaintId);
            System.out.println("departmentId" + departmentId);
            model.addAttribute("successMessage", "Department allocated successfully!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Failed to allocate department. Please try again.");
            e.printStackTrace();
        }
        return "AdminViewUserComplaintDetails";

    }

    @PostMapping("/search-user-complaints")
    public String searchUserComplaintDetails(RaiseComplaintDto raiseComplaintDto, Model model) {
        System.out.println("viewUserDetails method in AdminController..");

        List<RaiseComplaintDto> listOfComplaintTypeAndCity = adminService.searchByUserComplaintTypeAndCity(raiseComplaintDto.getComplaintType(), raiseComplaintDto.getCity());
        List<DepartmentDto> departments = adminService.getAllDepartments();
        if (!listOfComplaintTypeAndCity.isEmpty()) {
            model.addAttribute("viewRaiseComplaints", listOfComplaintTypeAndCity);
            model.addAttribute("departments", departments);

            return "AdminViewUserComplaintDetails";

        } else {
            List<RaiseComplaintDto> listOfComplaintTypeOrCity = adminService.searchByUserComplaintTypeOrCity(raiseComplaintDto.getComplaintType(), raiseComplaintDto.getCity());
            if (!listOfComplaintTypeOrCity.isEmpty()) {
                model.addAttribute("viewRaiseComplaints", listOfComplaintTypeOrCity);
                model.addAttribute("departments", departments);

                return "AdminViewUserComplaintDetails";
            }
        }
        return "AdminViewUserComplaintDetails";

    }


    @PostMapping("save-department")
    public String saveDepartment(DepartmentDto departmentDto, Model model) {
        System.out.println("Running saveDepartment method in admin controller...");
        boolean saveDepartment = adminService.saveDepartment(departmentDto);

        if (saveDepartment) {
            System.out.println("saveDepartment successfully");

            return "redirect:/department-profile";

        }
        System.out.println("saveDepartment not successfully");
        //model.addAttribute("savedfailed", "save Department successfully");
        return "redirect:/department";
    }

    @GetMapping("department")
    public String save(DepartmentDto departmentDto, Model model) {
        model.addAttribute("savedfailed", "save Department successfully");
        return "AddDepartment";
    }

    @GetMapping("department-profile")
    public String saved(DepartmentDto departmentDto, Model model) {
        model.addAttribute("savedsuccess", "save Department successfully");
        return "AdminProfile";
    }
    @GetMapping("/adddeptadmin")
    public String getform(Model model){
        List<DepartmentDto> departments = adminService.getAllDepartments();
        model.addAttribute("departments",departments);
        return "DepartmentAdmin";
    }


    @PostMapping("/save-departmentadmin")
    public String saveDepartmentAdminDetails(DepartmentDto departmentDto,DepartmentAdminDto departmentAdminDto, Model model) {
        System.out.println("Running saveDepartmentAdmin in admin controller....");
        DepartmentDto resultDto =adminService.searchByDepartmentName(departmentAdminDto.getDepartmentType());
        DepartmentDto  id= new DepartmentDto();
        departmentAdminDto.setDepartment(resultDto);

        boolean saved = adminService.saveDepartmentAdmin(departmentAdminDto);
        if (saved) {
            System.out.println("department admin details saved successfully...." + saved + ":  DepartmentAdminDto  :" + departmentAdminDto);
            model.addAttribute("departmentadminsuccess", "DepartmentAdminDetails saved successfullyy.....");
            System.out.println(departmentAdminDto.getDepartment());
            return "DepartmentAdmin";
        }
        else {
            System.out.println("department admin details is not saved ....");
            model.addAttribute("departmentadminfailed", "DepartmentAdminDetails not saved.....");
        }
        return "DepartmentAdmin";
    }




//    @PostMapping("/department-view-list")
//    public String viewDepartmentList(
//            @RequestParam("departmentId") Long departmentId,
//            @RequestParam("departmentAdminId") Long departmentAdminId,
//            Model model
//    ) {
//        try {
//            System.out.println("Running allocate department");
//
//            // Call the service method to allocate department
//            adminService.viewDepartmentList(departmentAdminId, departmentId);
//            System.out.println("departmentAdminId" + departmentAdminId);
//            System.out.println("departmentId" + departmentId);
//            model.addAttribute("successMessage", "Department allocated successfully!");
//        } catch (Exception e) {
//            model.addAttribute("errorMessage", "Failed to allocate department. Please try again.");
//            e.printStackTrace();
//        }
//        // Reload departments to be displayed
//        List<DepartmentDto> departments = adminService.getAllDepartments();
//        model.addAttribute("departments", departments);
//        return "DepartmentAdmin";
//
//    }

    @PostMapping("/departmentAdmin-signIn")
    public String signInSubmit(DepartmentAdminDto departmentAdminDto, Model model) {
        System.out.println("Running signInDepartmentAdmin method in AdminController...");
        DepartmentAdminDto adminDto = adminService.findByEmailIdAndPassword(departmentAdminDto.getDepartmentAdminEmailId(), departmentAdminDto.getDepartmentAdminPassword());
        System.out.println("after recive the dto from service" + adminDto);
        if (adminDto != null && !adminDto.isAccountLocked()) {
            adminService.resetFailedAttempts(departmentAdminDto.getDepartmentAdminEmailId());
            model.addAttribute("Loginresult", "Login Succcessfully with," + departmentAdminDto.getDepartmentAdminEmailId());
            System.out.println("(Controller) data are exists" + departmentAdminDto);

            return "DepartmentAdminProfile";

        } else {
            adminService.incrementFailedAttempts(departmentAdminDto.getDepartmentAdminEmailId());
            int failedAttempts = adminService.getFailedAttempts(departmentAdminDto.getDepartmentAdminEmailId());
            System.out.println("Failed attempts for " + departmentAdminDto.getDepartmentAdminEmailId() + ": " + failedAttempts);
            if (failedAttempts >= 3) {
                adminService.lockAccount(departmentAdminDto.getDepartmentAdminEmailId()); // Lock account after 3 failed attempts
                model.addAttribute("error", "Your account is locked due to too many failed attempts.");
                model.addAttribute("accountLocked", true);
                return "DepartmentAdminSignIn";
            } else {
                model.addAttribute("failed", "Invalid email id and password. Attempts: " + failedAttempts);
                model.addAttribute("accountLocked", false);
                System.out.println("(Controller) data are not exists" + departmentAdminDto);
                return "DepartmentAdminSignIn";
            }
        }
    }


        @PostMapping("admin-forgot-password")
        public String adminForgotPassword (@RequestParam("departmentAdminEmailId") String email, Model model)
        {
            System.out.println("Running forgetPassword method in ForgetPasswordController...");
            boolean success = adminService.adminForgotPassword(email);
            if (success) {
                model.addAttribute("forgotMessage", "A new Password has been sent to your emailId.");
                return "DepartmentAdminSignIn";
            } else {
                model.addAttribute("forgotError", "Email address not found.");
                return "DepartmentAdminForgotPassword";
            }

        }

    @PostMapping("admin-reset-password")
    public String passwordReset(@RequestParam("departmentAdminEmailId")  String email, String oldPassword, String newPassword, String confirmPassword,Model model) {
        System.out.println("email"+email+"old"+oldPassword+"new"+newPassword+"con"+confirmPassword);
        boolean resetSuccessful = adminService.changePassword(email, oldPassword, newPassword, confirmPassword);
        if (resetSuccessful) {
            System.out.println("Password reset Successful: " + resetSuccessful);
            model.addAttribute("passwordResetMessage", "Password reset successful");
            return "DepartmentAdminResetPassword";
        } else {
            model.addAttribute("passwordResetError", "Failed to reset password. Please check your password");
        }

        return "DepartmentAdminResetPassword";
    }
}




