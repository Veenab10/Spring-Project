package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.RaiseComplaintDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface RaiseComplaintService {

    boolean saveRaiseComplaintType(RaiseComplaintDto raiseComplaintDto);

    Optional<RaiseComplaintDto> findByUserId(int id);

    Optional<RaiseComplaintDto> findBySignedInUser(HttpServletRequest request);

    //edit complaint
    RaiseComplaintDto getComplaintById(int complaintId);

    //view complaint
    List<RaiseComplaintDto> getComplaintsByUserId(int userId);

    //update complaint
    List<RaiseComplaintDto> updateRaiseComplaintUserDetails(RaiseComplaintDto raiseComplaintDTO);
}
