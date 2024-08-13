package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.EmployeeDto;
import com.xworkz.xworkzProject.model.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl()
    {
        System.out.println("Created EmployeeServiceImpl...");
    }


    @Override
    public boolean saveEmployeeDtails(EmployeeDto employeeDto) {
        System.out.println("Running saveEmployeeDtails method in EmployeeServiceImpl...");
        boolean saveEmployeeDtails=employeeRepo.saveEmployeeDtails(employeeDto);
        if(saveEmployeeDtails)
        {
            System.out.println("saved EmployeeDtails successfully");
            return true;
        }
        System.out.println("saved EmployeeDtails failed");
        return false;
    }
}
