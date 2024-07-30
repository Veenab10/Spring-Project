package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.*;
import com.xworkz.xworkzProject.emailSending.MailSending;
import com.xworkz.xworkzProject.model.repo.AdminRepo;
import com.xworkz.xworkzProject.util.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.xworkz.xworkzProject.util.PasswordGenerator.generatePassword;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailSending mailSending;

    public AdminServiceImpl() {
        System.out.println("Created AdminServiceImpl");
    }


    @Override
    public AdminDto findByAdminEmailIdAndPassword(String adminEmailId, String adminPassword) {
        System.out.println("Running findByAdminEmailIdAndPassword method in AdminServiceImpl ");
        AdminDto adminDto = adminRepo.findByAdminEmailIdAndPassword(adminEmailId, adminPassword);
        if (adminDto != null) {
            System.out.println("Service:saved successfully");
            return adminDto;
        }
        System.out.println("Service:Not saved successfully");
        return null;
    }


    @Override
    public List<SignupDto> findByUSerId() {

        System.out.println("findById method in AdminServiceImpl..");
        List<SignupDto> dtoData = adminRepo.findByUSerId();
        if (dtoData != null) {
            System.out.println("findById data successful in AdminServiceImpl..");
            return dtoData;
        } else {
            System.out.println("findById data not successful in AdminServiceImpl..");
        }
        return Collections.emptyList();
    }

    //findByUserId for admin view
    @Override
    public List<RaiseComplaintDto> findByUSerComplaintId() {

        System.out.println("findById method in AdminServiceImpl..");
        List<RaiseComplaintDto> dtoData = adminRepo.findByUSerComplaintId();
        if (dtoData != null) {
            System.out.println("findById data successful in AdminServiceImpl..");
            return dtoData;
        } else {
            System.out.println("findById data not successful in AdminServiceImpl..");
        }

        return Collections.emptyList();
    }


    @Override
    public List<RaiseComplaintDto> searchByUserComplaintTypeAndCity(String complaintType, String city) {
        System.out.println("Running searchByUserComplaintTypeAndCity method in AdminServiceImpl...");
        List<RaiseComplaintDto> raiseComplaintDtos = adminRepo.searchByUserComplaintTypeAndCity(complaintType, city);
        if (!raiseComplaintDtos.isEmpty()) {
            System.out.println("searchByUserComplaintTypeAndCity data successful in AdminServiceImpl..");
            return raiseComplaintDtos;
        } else {
            System.out.println("searchByUserComplaintTypeAndCity data not successful in AdminServiceImpl..");
        }
        return Collections.emptyList();
    }

//    @Override
//    public List<RaiseComplaintDto> getListOfComplaintTypes(String complaintType) {
//        System.out.println("Running searchByComplaintType method in AdminServiceImpl... ");
//        List<RaiseComplaintDto> raiseComplaintDtoList=adminRepo.searchByComplaintType(complaintType);
//        if(!raiseComplaintDtoList.isEmpty())
//        {
//            System.out.println("successfully searched list in AdminServiceImpl");
//            return raiseComplaintDtoList;
//        }
//        return Collections.emptyList();
//    }
//
//    @Override
//    public List<RaiseComplaintDto> searchByCity(String city) {
//        System.out.println("Running searchByCity method in AdminServiceImpl... ");
//        List<RaiseComplaintDto> raiseComplaintDtoList=adminRepo.searchByCity(city);
//        if(!raiseComplaintDtoList.isEmpty())
//        {
//            System.out.println("successfully searched list in AdminServiceImpl");
//            return raiseComplaintDtoList;
//        }
//        return Collections.emptyList();
//    }

    @Override
    public List<RaiseComplaintDto> searchByUserComplaintTypeOrCity(String complaintType, String city) {
        System.out.println("Running searchByUserComplaintTypeOrCity method in AdminServiceImpl...");
        List<RaiseComplaintDto> raiseComplaintDtos = adminRepo.searchByUserComplaintTypeOrCity(complaintType, city);
        if (!raiseComplaintDtos.isEmpty()) {
            System.out.println("searchByUserComplaintTypeOrCity data successful in AdminServiceImpl..");
            return raiseComplaintDtos;
        } else {
            System.out.println("searchByUserComplaintTypeOrCity data not successful in AdminServiceImpl..");
        }
        return Collections.emptyList();
    }

    @Override
    public boolean saveDepartment(DepartmentDto departmentDto) {
        System.out.println("Running saveDepartment method in AdminServiceImpl... ");
        boolean saveDepartment = adminRepo.saveDepartment(departmentDto);
        if (saveDepartment) {
            System.out.println("Save department successfully" + departmentDto);
            return true;
        }
        System.out.println("not saved department successfully" + departmentDto);
        return false;
    }

    public List<DepartmentDto> getAllDepartments() {
        return adminRepo.getAllDepartments(); // Retrieve all departments
    }

    @Override
    public void allocateDepartment(Long complaintId, Long departmentId, String status) {
        System.out.println("Running  allocateDepartment method in adminserviceimpl...");
        // Delegate the department allocation to the repository
        adminRepo.allocateDepartment(complaintId, departmentId, status);
    }

    @Override
    public boolean saveDepartmentAdmin(DepartmentAdminDto departmentAdminDto) {
        System.out.println("Running saveDepartmentAdmin in AdminService...");

        String password = generatePassword(); // Generate a password
        String encodedPassword = passwordEncoder.encode(password); // Encode password

        departmentAdminDto.setDepartmentAdminPassword(encodedPassword); // Set encoded password

        boolean savedDepartmentAdmin = adminRepo.saveDepartmentAdmin(departmentAdminDto);

        if (savedDepartmentAdmin) {
            System.out.println("Department Admin details saved successfully......" + departmentAdminDto);
            mailSending.sendDepartmentPassword(departmentAdminDto); // Send plain password
            return true;
        }
        System.out.println("Department Admin details not saved ......");
        return false;
    }

    @Override
    public DepartmentAdminDto findByEmailIdAndPassword(String emailId, String password) {
        System.out.println("Service: findByEmailIdAndPassword method...");
        DepartmentAdminDto departmentAdminDto = this.adminRepo.findByEmailId(emailId);
        System.out.println("Service: data retrieved" + departmentAdminDto);

        if (departmentAdminDto != null && passwordEncoder.matches(password, departmentAdminDto.getDepartmentAdminPassword())) {
            departmentAdminDto.setDepartmentAdminPassword(null); // Clear the password for security
            return departmentAdminDto;
        }

        System.out.println("Service: data not found or password mismatch");
        return null;
    }


}
