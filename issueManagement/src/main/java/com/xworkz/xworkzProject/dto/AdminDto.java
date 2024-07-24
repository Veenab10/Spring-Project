package com.xworkz.xworkzProject.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class AdminDto {

    public AdminDto()
    {
        System.out.println("Created AdminDto");
    }

    @Column(name = "admin_id")
    @Id
    private int id;

    @Column(name = "admin_email_id")
    private  String adminEmailId;

    @Column(name="admin_password")
    private String adminPassword;

    public String getAdminEmailId() {
        return adminEmailId;
    }

    public void setAdminEmailId(String adminEmailId) {
        this.adminEmailId = adminEmailId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "AdminDto{" +
                "adminEmailId='" + adminEmailId + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
}
