package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.RaiseComplaintDto;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface RaiseComplaintService {

    boolean saveRaiseComplaintType(RaiseComplaintDto raiseComplaintDto);

    Optional<RaiseComplaintDto> findByUserId(int id);

    Optional<RaiseComplaintDto> findBySignedInUser(HttpServletRequest request);
}
