package com.xworkz.xworkzProject.controller;

import com.xworkz.xworkzProject.dto.DepartmentDto;
import com.xworkz.xworkzProject.dto.EmployeeDto;
import com.xworkz.xworkzProject.model.repo.AdminRepo;
import com.xworkz.xworkzProject.model.service.AdminService;
import com.xworkz.xworkzProject.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AdminService adminService;

    public EmployeeController()
    {
        System.out.println("Created EmployeeController...");
    }

    @PostMapping("save-employee-details")
    public String saveEmployeeDetails(EmployeeDto employeeDto, RedirectAttributes redirectAttributes) {
        System.out.println("Running saveEmployeeDetails method in Employee Controller... ");
        DepartmentDto resultDto = adminService.searchByDepartmentName(employeeDto.getDepartmentName());
        System.out.println("resultDto"+resultDto);
        employeeDto.setDepartmentId(resultDto);
        boolean saveEmployeeDetails = employeeService.saveEmployeeDtails(employeeDto);

        if (saveEmployeeDetails) {
            System.out.println("Save Employee Details successfully...");
            redirectAttributes.addFlashAttribute("successMsg", "Successfully added employee details...");
        } else {
            System.out.println("Save Employee Details failed...");
            redirectAttributes.addFlashAttribute("failedMsg", "Failed to add employee details...");
        }

        // Redirect to a different URL to avoid resubmission on refresh
        return "redirect:/view-department-list";
    }

    @GetMapping("/view-department-list")
    public String viewDepartmentList(Model model){
        List<DepartmentDto> departments = adminService.getAllDepartments();
        model.addAttribute("departments",departments);
        return "Employee";
    }

}
