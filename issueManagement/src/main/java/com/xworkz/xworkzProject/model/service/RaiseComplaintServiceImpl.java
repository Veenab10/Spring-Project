package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.RaiseComplaintDto;
import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.repo.RaiseComplaintRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

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


    @Override
    public Optional<RaiseComplaintDto> findByUserId(int id) {
        return raiseComplaintRepo.findByUserId(id);
    }

    @Override
    public Optional<RaiseComplaintDto> findBySignedInUser(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        SignupDto signedInUser = (SignupDto) httpSession.getAttribute("signupDto");
        if (signedInUser != null) {
            return raiseComplaintRepo.findByUserId(signedInUser.getId());
        }
        return Optional.empty();
    }

}



