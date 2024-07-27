package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.AdminDto;
import com.xworkz.xworkzProject.dto.DepartmentDto;
import com.xworkz.xworkzProject.dto.RaiseComplaintDto;
import com.xworkz.xworkzProject.dto.SignupDto;

import java.util.List;

public interface AdminRepo {

    AdminDto findByAdminEmailIdAndPassword(String adminEmailId, String adminPassword);

    //findByUserId for admin view
    List<SignupDto> findByUSerId();

    //findByComplaintId for admin view
    List<RaiseComplaintDto> findByUSerComplaintId();


    //findByComplaintTypeAndcity for admin view
    List<RaiseComplaintDto> searchByUserComplaintTypeAndCity(String complaintType,String city);


    //findByComplaintTypeORcity for admin view
    List<RaiseComplaintDto> searchByUserComplaintTypeOrCity(String complaintType,String city);

    //List<RaiseComplaintDto> getListOfComplaintTypes(String complaintType);
    //savingdepartment
    boolean saveDepartment(DepartmentDto departmentDto);

    //getAllDepartments
    List<DepartmentDto> getAllDepartments();

    void allocateDepartment(Long complaintId, Long departmentId, String status);

}
