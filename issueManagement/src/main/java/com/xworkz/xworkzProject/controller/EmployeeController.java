package com.xworkz.xworkzProject.controller;

import com.xworkz.xworkzProject.dto.DepartmentDto;
import com.xworkz.xworkzProject.dto.EmployeeDto;
import com.xworkz.xworkzProject.model.repo.AdminRepo;
import com.xworkz.xworkzProject.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AdminRepo adminRepo;

    public EmployeeController()
    {
        System.out.println("Created EmployeeController...");
    }

    @GetMapping("/view-department-list")
    public String viewDepartmentList(Model model){
        List<DepartmentDto> departments = adminRepo.getAllDepartments();
        model.addAttribute("departments",departments);
        return "Employee";
    }

    @PostMapping("save-employee-details")
    public String saveEmployeeDetails(EmployeeDto employeeDto, Model model)
    {
        System.out.println("Running saveEmployeeDetails method in Employee Controller... ");
        boolean saveEmployeeDtails=employeeService.saveEmployeeDtails(employeeDto);
        if(saveEmployeeDtails)
        {
            System.out.println("save EmployeeDtails successfully...");
            return "Employee";
        }
        System.out.println("save EmployeeDtails failed...");
        return "Employee";
    }
}
