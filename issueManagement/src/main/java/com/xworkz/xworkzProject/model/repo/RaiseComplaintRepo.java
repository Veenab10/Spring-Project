package com.xworkz.xworkzProject.model.repo;


import com.xworkz.xworkzProject.dto.RaiseComplaintDto;

import java.util.List;
import java.util.Optional;

public interface RaiseComplaintRepo {

    boolean saveRaiseComplaintType(RaiseComplaintDto raiseComplaintDto);

    Optional<RaiseComplaintDto> findByUserId(int id);

    //complaint view
    Optional<RaiseComplaintDto> findByComplaintId(Long complaintId);

    //edit
    List<RaiseComplaintDto> findByRaiseComplaint(int id);

    //update
    RaiseComplaintDto updateRaiseComplaintUserDetails(RaiseComplaintDto raiseComplaintDto);


}
