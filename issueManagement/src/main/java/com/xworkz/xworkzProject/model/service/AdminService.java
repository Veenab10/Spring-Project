package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.*;

import java.util.List;

public interface AdminService {

    AdminDto findByAdminEmailIdAndPassword(String adminEmailId, String adminPassword);

    //findByUserId for admin view
    List<SignupDto> findByUSerId();

    //findByComplaintId for admin view
    List<RaiseComplaintDto> findByUSerComplaintId();

    //findByComplaintTypeAndcity for admin view
    List<RaiseComplaintDto> searchByUserComplaintTypeAndCity(String complaintType,String city);

    //findByComplaintTypeORcity for admin view
    List<RaiseComplaintDto> searchByUserComplaintTypeOrCity(String complaintType,String city);

    //savingdepartment
    boolean saveDepartment(DepartmentDto departmentDto);

    //List<RaiseComplaintDto> getListOfComplaintTypes(String complaintType);

    //getAllDepartments
    List<DepartmentDto> getAllDepartments();

    void allocateDepartment(Long complaintId, Long departmentId,String status);

    //from here im going to save department admin details
    boolean saveDepartmentAdmin(DepartmentAdminDto departmentAdminDto);

    DepartmentAdminDto findByEmailIdAndPassword(String emailId, String password);



}
