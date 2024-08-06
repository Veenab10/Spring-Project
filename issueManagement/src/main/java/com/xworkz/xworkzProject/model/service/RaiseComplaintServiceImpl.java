package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.DepartmentDto;
import com.xworkz.xworkzProject.dto.RaiseComplaintDto;
import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.repo.RaiseComplaintRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class RaiseComplaintServiceImpl implements RaiseComplaintService {

    @Autowired
    private RaiseComplaintRepo raiseComplaintRepo;

    public RaiseComplaintServiceImpl() {
        System.out.println("Created RaiseComplaintServiceImpl");

    }

    public List<DepartmentDto> getAllDepartments() {

        return raiseComplaintRepo.getAllDepartments(); // Retrieve all departments
    }

    @Override
    public DepartmentDto searchByDepartmentName(String departmentName) {
        System.out.println("Running searchByDepartmentName method in AdminServiceImpl... ");
        DepartmentDto departmentDto=raiseComplaintRepo.searchByDepartmentName(departmentName);
        if(departmentDto!=null)
        {
            System.out.println("FindBy Department Name successfully"+departmentName);
            return departmentDto;
        }

        System.out.println("FindBy Department Name successfully"+departmentName);
        return null;
    }


    @Override
    public boolean saveRaiseComplaintType(RaiseComplaintDto raiseComplaintDto) {
        System.out.println("Running saveRaiseComplaintType method in RaiseComplaintServiceImpl ");
        boolean save = raiseComplaintRepo.saveRaiseComplaintType(raiseComplaintDto);
        if (save) {
            System.out.println(" saved RaiseComplaint successfully ");
        } else {
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




    @Override
    public List<RaiseComplaintDto> getComplaintsByUserId(int userId) {
        return raiseComplaintRepo.findByRaiseComplaint(userId);
    }

    //edit

    public RaiseComplaintDto getComplaintById(Long complaintId) {
        return raiseComplaintRepo.findByComplaintId(complaintId).orElse(null);
    }

    //update

    @Override
    public List<RaiseComplaintDto> updateRaiseComplaintUserDetails(RaiseComplaintDto raiseComplaintDTO) {
        RaiseComplaintDto raiseComplaintDto = this.raiseComplaintRepo.findByComplaintId(raiseComplaintDTO.getComplaintId()).get();
        raiseComplaintDTO.setUserId(raiseComplaintDto.getUserId());
        RaiseComplaintDto raiseComplaintDTO1 = raiseComplaintRepo.updateRaiseComplaintUserDetails(raiseComplaintDTO);
        List<RaiseComplaintDto> dtos = this.raiseComplaintRepo.findByRaiseComplaint(raiseComplaintDTO1.getUserId().getId());
        if (dtos != null) {
            System.out.println("update data successful");
            return dtos;
        }
        else {
            System.out.println("update not successful");
            return null;

        }

    }



}



