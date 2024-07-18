package com.xworkz.xworkzProject.model.repo;


import com.xworkz.xworkzProject.dto.ImageUploadDto;
import com.xworkz.xworkzProject.dto.RaiseComplaintDto;

import java.util.Optional;

public interface RaiseComplaintRepo {

    boolean saveRaiseComplaintType(RaiseComplaintDto raiseComplaintDto);

    Optional<RaiseComplaintDto> findByUserId(int id);
}
