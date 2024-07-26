package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.AdminDto;
import com.xworkz.xworkzProject.dto.RaiseComplaintDto;
import com.xworkz.xworkzProject.dto.SignupDto;

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

    //findByComplaintType for admin view
    //List<RaiseComplaintDto> searchByComplaintType(String complaintType);

    //findByCity for admin view
    //List<RaiseComplaintDto> searchByCity(String city);
}
