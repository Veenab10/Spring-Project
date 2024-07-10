package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.repo.AccountLockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountLockServiceImpl implements AccountLockService {

    @Autowired
    private AccountLockRepo accountLockRepo;

    public AccountLockServiceImpl()
    {
        System.out.println("Created AccountLockServiceImpl");
    }

    @Override
    public SignupDto findByEmailId(String emailId) {
        System.out.println("Running findByEmailId method...");
        SignupDto signupDto=accountLockRepo.findByEmailId(emailId);
        if(signupDto!=null)
        {
            System.out.println("(Service) data exist"+signupDto);
        }
        else {
            System.out.println("(Service) data not exist"+signupDto);

        }
        return signupDto;
    }

//    @Override
//    public void incrementFailedAttempts(String emailId) {
//        SignupDto user = accountLockRepo.findByEmailId(emailId);
//        if (user != null) {
//            int attempts = user.getFailedAttempts() + 1;
//            user.setFailedAttempts(attempts);
//            if (attempts >= 3) {
//                user.setAccountLocked(true);
//            }
//            accountLockRepo.update(user);
//        }
//    }

    @Override
    public void incrementFailedAttempts(String emailId) {
        SignupDto user = accountLockRepo.findByEmailId(emailId);
        if (user != null) {
            int attempts = user.getFailedAttempts() + 1;
            user.setFailedAttempts(attempts);
            if (attempts >= 3) {
                user.setAccountLocked(true);
            }
            accountLockRepo.update(user); // Ensure you update the changes
        }
    }





    @Override
    public int getFailedAttempts(String emailId) {
        SignupDto signupDto = accountLockRepo.findByEmailId(emailId);
        if (signupDto != null) {
            return signupDto.getFailedAttempts();
        } else {
            return 0;
        }
    }



    @Override
    public void resetFailedAttempts(String emailId) {
        SignupDto user = accountLockRepo.findByEmailId(emailId);
        if (user != null) {
            user.setFailedAttempts(0);
            accountLockRepo.update(user);
        }
    }
    @Override
    public void lockAccount(String emailId) {
        SignupDto user=accountLockRepo.findByEmailId(emailId);
        if(user != null)
        {
            user.setAccountLocked(true);
            accountLockRepo.update(user);
        }

    }

    @Override
    public void unlockAccount(String emailId) {
        SignupDto user = accountLockRepo.findByEmailId(emailId);
        if (user != null) {
            user.setAccountLocked(false);
            accountLockRepo.update(user);
        }

    }
}
