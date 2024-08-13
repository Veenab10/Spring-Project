package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.EmployeeDto;

public interface EmployeeRepo {

    boolean saveEmployeeDtails(EmployeeDto employeeDto);
}
