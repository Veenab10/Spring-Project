package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.AdminDto;
import com.xworkz.xworkzProject.dto.RaiseComplaintDto;
import com.xworkz.xworkzProject.dto.SignupDto;

import java.util.List;

public interface AdminRepo {

    AdminDto findByAdminEmailIdAndPassword(String adminEmailId, String adminPassword);

    //findByUserId for admin view
    List<SignupDto> findByUSerId();

    //findByComplaintId for admin view
    List<RaiseComplaintDto> findByUSerComplaintId();

    //findByComplaintType for admin view
    List<RaiseComplaintDto> findByUserComplaintType(String complaintType);


}
