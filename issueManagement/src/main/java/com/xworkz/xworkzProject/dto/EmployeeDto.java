package com.xworkz.xworkzProject.dto;

import javax.persistence.*;

@Entity
@Table(name="employee_details")
public class EmployeeDto {

    @Column(name = "employee_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_email")
    private String email;

    @Column(name = "employee_password")
    private String password;

    @Column(name = "employee_contact_number")
    private Long contactNumber;

    @Column(name = "employee_alternative_number")
    private Long alternativeContactNumber;


//    @Column(name = "")
//    private String area;

    @Column(name = "department_name")
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentDto departmentId;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Long getAlternativeContactNumber() {
        return alternativeContactNumber;
    }

    public void setAlternativeContactNumber(Long alternativeContactNumber) {
        this.alternativeContactNumber = alternativeContactNumber;
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

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", contactNumber=" + contactNumber +
                ", alternativeContactNumber=" + alternativeContactNumber +
                ", departmentName='" + departmentName + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
