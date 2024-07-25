package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.AdminDto;
import com.xworkz.xworkzProject.dto.RaiseComplaintDto;
import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    public AdminServiceImpl()
    {
        System.out.println("Created AdminServiceImpl");
    }


    @Override
    public AdminDto findByAdminEmailIdAndPassword(String adminEmailId, String adminPassword) {
        System.out.println("Running findByAdminEmailIdAndPassword method in AdminServiceImpl ");
        AdminDto adminDto=adminRepo.findByAdminEmailIdAndPassword(adminEmailId,adminPassword);
        if(adminDto!=null)
        {
            System.out.println("Service:saved successfully");
            return adminDto;
        }
        System.out.println("Service:Not saved successfully");
        return null;
    }


    @Override
    public List<SignupDto> findByUSerId() {

        System.out.println("findById method in AdminServiceImpl..");
        List<SignupDto> dtoData=  adminRepo.findByUSerId();
        if(dtoData!=null)
        {
            System.out.println("findById data successful in AdminServiceImpl..");
            return dtoData;
        }
        else
        {
            System.out.println("findById data not successful in AdminServiceImpl..");
        }
        return Collections.emptyList();
    }

    //findByUserId for admin view
    @Override
    public List<RaiseComplaintDto> findByUSerComplaintId() {

        System.out.println("findById method in AdminServiceImpl..");
        List<RaiseComplaintDto> dtoData=  adminRepo.findByUSerComplaintId();
        if(dtoData!=null)
        {
            System.out.println("findById data successful in AdminServiceImpl..");
            return dtoData;
        }
        else
        {
            System.out.println("findById data not successful in AdminServiceImpl..");
        }

        return Collections.emptyList();
    }


    @Override
    public List<RaiseComplaintDto> searchByUserComplaintTypeAndCity(String complaintType,String city) {
        System.out.println("Running searchByUserComplaintTypeAndCity method in AdminServiceImpl...");
        List<RaiseComplaintDto> raiseComplaintDtos=adminRepo.searchByUserComplaintTypeAndCity(complaintType,city);
        if(raiseComplaintDtos.isEmpty())
        {
            System.out.println("searchByUserComplaintTypeAndCity data successful in AdminServiceImpl..");
            return raiseComplaintDtos;
        }
        else
        {
            System.out.println("searchByUserComplaintTypeAndCity data not successful in AdminServiceImpl..");
        }
        return Collections.emptyList();
    }

    @Override
    public List<RaiseComplaintDto> searchByUserComplaintTypeOrCity(String complaintType, String city) {
        System.out.println("Running searchByUserComplaintTypeOrCity method in AdminServiceImpl...");
        List<RaiseComplaintDto> raiseComplaintDtos=adminRepo.searchByUserComplaintTypeOrCity(complaintType,city);
        if(raiseComplaintDtos.isEmpty())
        {
            System.out.println("searchByUserComplaintTypeOrCity data successful in AdminServiceImpl..");
            return raiseComplaintDtos;
        }
        else
        {
            System.out.println("searchByUserComplaintTypeOrCity data not successful in AdminServiceImpl..");
        }
        return Collections.emptyList();
    }

}
