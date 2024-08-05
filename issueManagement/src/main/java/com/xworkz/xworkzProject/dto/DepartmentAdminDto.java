package com.xworkz.xworkzProject.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "department_admin")
public class DepartmentAdminDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Ensure auto-increment
    @Column(name = "department_admin_id")
    private Long departmentAdminId;

    @Column(name = "department_admin_name")
    private String departmentAdminName;

    @Column(name = "department_admin_type")
    private String departmentType;

    @Column(name = "department_admin_email_id")
    private String departmentAdminEmailId;

    @Column(name = "department_admin_contact_number")
    private Long departmentAdminContactNumber;

    @Column(name = "department_admin_alternative_number")
    private Long departmentAdminAlternativeContactNumber;

    @Column(name = "department_admin_password")
    private String departmentAdminPassword;

    @Column(name = "account_locked")
    private boolean accountLocked=false;

    @Column(name = "failed_attempts")
    private int failedAttempts = 0;

    // Getters and setters...


    public Long getDepartmentAdminId() {
        return departmentAdminId;
    }

    public void setDepartmentAdminId(Long departmentAdminId) {
        this.departmentAdminId = departmentAdminId;
    }

    public String getDepartmentAdminName() {
        return departmentAdminName;
    }

    public void setDepartmentAdminName(String departmentAdminName) {
        this.departmentAdminName = departmentAdminName;
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }

    public String getDepartmentAdminEmailId() {
        return departmentAdminEmailId;
    }

    public void setDepartmentAdminEmailId(String departmentAdminEmailId) {
        this.departmentAdminEmailId = departmentAdminEmailId;
    }

    public Long getDepartmentAdminContactNumber() {
        return departmentAdminContactNumber;
    }

    public void setDepartmentAdminContactNumber(Long departmentAdminContactNumber) {
        this.departmentAdminContactNumber = departmentAdminContactNumber;
    }

    public Long getDepartmentAdminAlternativeContactNumber() {
        return departmentAdminAlternativeContactNumber;
    }

    public void setDepartmentAdminAlternativeContactNumber(Long departmentAdminAlternativeContactNumber) {
        this.departmentAdminAlternativeContactNumber = departmentAdminAlternativeContactNumber;
    }

    public String getDepartmentAdminPassword() {
        return departmentAdminPassword;
    }

    public void setDepartmentAdminPassword(String departmentAdminPassword) {
        this.departmentAdminPassword = departmentAdminPassword;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }


//    @ManyToMany
//    @JoinColumn(name = "department_id")
//    private Long department;

    @ManyToOne(fetch = FetchType.LAZY) // Example mapping assuming many images to one signup
    @JoinColumn(name = "department_id", referencedColumnName = "department_id") // Adjust as per your schema
    private DepartmentDto department;

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "DepartmentAdminDto{" +
                "departmentAdminId=" + departmentAdminId +
                ", departmentAdminName='" + departmentAdminName + '\'' +
                ", departmentType='" + departmentType + '\'' +
                ", departmentAdminEmailId='" + departmentAdminEmailId + '\'' +
                ", departmentAdminContactNumber=" + departmentAdminContactNumber +
                ", departmentAdminAlternativeContactNumber=" + departmentAdminAlternativeContactNumber +
                ", departmentAdminPassword='" + departmentAdminPassword + '\'' +
                ", accountLocked=" + accountLocked +
                ", failedAttempts=" + failedAttempts +
                ", department=" + department +
                '}';
    }
}
