package com.xworkz.xworkzProject.dto;

import javax.persistence.*;

@Entity
@Table(name = "employee_details")
public class EmployeeDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_designation")
    private String designation;

    @Column(name = "employee_email")
    private String employeeEmail;

    @Column(name = "employee_password")
    private String  employeePassword;

    @Column(name = "employee_contact_number")
    private String employeeContactNumber;

    @Column(name = "employee_address")
    private String address;

    @Column(name = "employee_department_name")
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "departments_id", referencedColumnName = "department_id")
    private DepartmentDto departmentId;

    @Column(name = "employee_status")
    private String status;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeContactNumber() {
        return employeeContactNumber;
    }

    public void setEmployeeContactNumber(String employeeContactNumber) {
        this.employeeContactNumber = employeeContactNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public DepartmentDto getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(DepartmentDto departmentId) {
        this.departmentId = departmentId;
    }


    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", designation='" + designation + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeePassword='" + employeePassword + '\'' +
                ", employeeContactNumber='" + employeeContactNumber + '\'' +
                ", address='" + address + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentId=" + departmentId +
                ", status='" + status + '\'' +
                '}';
    }
}
