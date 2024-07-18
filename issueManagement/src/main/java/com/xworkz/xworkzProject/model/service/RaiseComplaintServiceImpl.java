package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.RaiseComplaintDto;
import com.xworkz.xworkzProject.model.repo.RaiseComplaintRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaiseComplaintServiceImpl implements RaiseComplaintService{

    @Autowired
    private RaiseComplaintRepo raiseComplaintRepo;

    public RaiseComplaintServiceImpl()
    {
        System.out.println("Created RaiseComplaintServiceImpl");

    }


    @Override
    public boolean saveRaiseComplaintType(RaiseComplaintDto raiseComplaintDto) {
        System.out.println("Running saveRaiseComplaintType method in RaiseComplaintServiceImpl ");
        boolean save=raiseComplaintRepo.saveRaiseComplaintType(raiseComplaintDto);
        if(save)
        {
            System.out.println(" saved RaiseComplaint successfully ");
        }
        else {
            System.out.println(" Not saved RaiseComplaint successfully ");
        }
        return true;
    }
}
