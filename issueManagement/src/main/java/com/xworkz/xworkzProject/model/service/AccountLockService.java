package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.SignupDto;

public interface AccountLockService {
    SignupDto findByEmailId(String emailId);

    void incrementFailedAttempts(String emailId);

    int getFailedAttempts(String emailId);

    void resetFailedAttempts(String emailId);

    void lockAccount(String emailId);

    void unlockAccount(String email);
}
