package com.xworkz.xworkzProject.model.service;

import com.xworkz.xworkzProject.dto.*;
import com.xworkz.xworkzProject.emailSending.MailSending;
import com.xworkz.xworkzProject.model.repo.AdminRepo;
import com.xworkz.xworkzProject.util.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.xworkz.xworkzProject.util.PasswordGenerator.generatePassword;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailSending mailSending;

    public AdminServiceImpl() {
        System.out.println("Created AdminServiceImpl");
    }


    @Override
    public AdminDto findByAdminEmailIdAndPassword(String adminEmailId, String adminPassword) {
        System.out.println("Running findByAdminEmailIdAndPassword method in AdminServiceImpl ");
        AdminDto adminDto = adminRepo.findByAdminEmailIdAndPassword(adminEmailId, adminPassword);
        if (adminDto != null) {
            System.out.println("Service:saved successfully");
            return adminDto;
        }
        System.out.println("Service:Not saved successfully");
        return null;
    }


    @Override
    public List<SignupDto> findByUSerId() {

        System.out.println("findById method in AdminServiceImpl..");
        List<SignupDto> dtoData = adminRepo.findByUSerId();
        if (dtoData != null) {
            System.out.println("findById data successful in AdminServiceImpl..");
            return dtoData;
        } else {
            System.out.println("findById data not successful in AdminServiceImpl..");
        }
        return Collections.emptyList();
    }

    //findByUserId for admin view
    @Override
    public List<RaiseComplaintDto> findByUSerComplaintId() {

        System.out.println("findById method in AdminServiceImpl..");
        List<RaiseComplaintDto> dtoData = adminRepo.findByUSerComplaintId();
        if (dtoData != null) {
            System.out.println("findById data successful in AdminServiceImpl..");
            return dtoData;
        } else {
            System.out.println("findById data not successful in AdminServiceImpl..");
        }

        return Collections.emptyList();
    }


    @Override
    public List<RaiseComplaintDto> searchByUserComplaintTypeAndCity(String complaintType, String city) {
        System.out.println("Running searchByUserComplaintTypeAndCity method in AdminServiceImpl...");
        List<RaiseComplaintDto> raiseComplaintDtos = adminRepo.searchByUserComplaintTypeAndCity(complaintType, city);
        if (!raiseComplaintDtos.isEmpty()) {
            System.out.println("searchByUserComplaintTypeAndCity data successful in AdminServiceImpl..");
            return raiseComplaintDtos;
        } else {
            System.out.println("searchByUserComplaintTypeAndCity data not successful in AdminServiceImpl..");
        }
        return Collections.emptyList();
    }

//    @Override
//    public List<RaiseComplaintDto> getListOfComplaintTypes(String complaintType) {
//        System.out.println("Running searchByComplaintType method in AdminServiceImpl... ");
//        List<RaiseComplaintDto> raiseComplaintDtoList=adminRepo.searchByComplaintType(complaintType);
//        if(!raiseComplaintDtoList.isEmpty())
//        {
//            System.out.println("successfully searched list in AdminServiceImpl");
//            return raiseComplaintDtoList;
//        }
//        return Collections.emptyList();
//    }
//
//    @Override
//    public List<RaiseComplaintDto> searchByCity(String city) {
//        System.out.println("Running searchByCity method in AdminServiceImpl... ");
//        List<RaiseComplaintDto> raiseComplaintDtoList=adminRepo.searchByCity(city);
//        if(!raiseComplaintDtoList.isEmpty())
//        {
//            System.out.println("successfully searched list in AdminServiceImpl");
//            return raiseComplaintDtoList;
//        }
//        return Collections.emptyList();
//    }

    @Override
    public List<RaiseComplaintDto> searchByUserComplaintTypeOrCity(String complaintType, String city) {
        System.out.println("Running searchByUserComplaintTypeOrCity method in AdminServiceImpl...");
        List<RaiseComplaintDto> raiseComplaintDtos = adminRepo.searchByUserComplaintTypeOrCity(complaintType, city);
        if (!raiseComplaintDtos.isEmpty()) {
            System.out.println("searchByUserComplaintTypeOrCity data successful in AdminServiceImpl..");
            return raiseComplaintDtos;
        } else {
            System.out.println("searchByUserComplaintTypeOrCity data not successful in AdminServiceImpl..");
        }
        return Collections.emptyList();
    }

    @Override
    public boolean saveDepartment(DepartmentDto departmentDto) {
        System.out.println("Running saveDepartment method in AdminServiceImpl... ");
        boolean saveDepartment = adminRepo.saveDepartment(departmentDto);
        if (saveDepartment) {
            System.out.println("Save department successfully" + departmentDto);
            return true;
        }
        System.out.println("not saved department successfully" + departmentDto);
        return false;
    }

    public List<DepartmentDto> getAllDepartments() {

        return adminRepo.getAllDepartments(); // Retrieve all departments
    }

    @Override
    public void allocateDepartment(Long complaintId, Long departmentId, String status) {
        System.out.println("Running  allocateDepartment method in adminserviceimpl...");
        // Delegate the department allocation to the repository
        adminRepo.allocateDepartment(complaintId, departmentId, status);
    }

    @Override
    public boolean saveDepartmentAdmin(DepartmentAdminDto departmentAdminDto) {
        System.out.println("Running saveDepartmentAdmin in AdminService...");

        String password=generatePassword();
        departmentAdminDto.setDepartmentAdminPassword(passwordEncoder.encode(password)); // Set encoded password

        boolean savedDepartmentAdmin = adminRepo.saveDepartmentAdmin(departmentAdminDto);

        if (savedDepartmentAdmin) {
            System.out.println("Department Admin details saved successfully......" + departmentAdminDto);
            departmentAdminDto.setDepartmentAdminPassword(password);
            mailSending.sendDepartmentPassword(departmentAdminDto); // Send plain password
            return true;

        }
        System.out.println("Department Admin details not saved ......");
        return false;
    }

//    @Override
//    public void viewDepartmentList( Long departmentId,Long departmentAdminId) {
//        System.out.println("Running  viewDepartmentList method in adminserviceimpl...");
//        // Delegate the department allocation to the repository
//        adminRepo.viewDepartmentList(departmentId,departmentAdminId);
//    }

    @Override
    public DepartmentAdminDto findByEmailPasswordAndDepartmentType(String emailId, String password,String departmentType) {
        System.out.println("Service: findByEmailIdAndPassword method...");
        DepartmentAdminDto departmentAdminDto = this.adminRepo.findByEmailId(emailId);
        System.out.println("Service: data retrieved" + departmentAdminDto);

        if (departmentAdminDto != null && passwordEncoder.matches(password, departmentAdminDto.getDepartmentAdminPassword()) && !departmentAdminDto.isAccountLocked() && departmentAdminDto.getDepartmentType().equals(departmentType)) {
            departmentAdminDto.setDepartmentAdminPassword(null); // Clear the password for security
            return departmentAdminDto;
        }

        System.out.println("Service: data not found or password mismatch");
        return null;
    }

    @Override
    public void incrementFailedAttempts(String email) {
        DepartmentAdminDto departmentAdminDto = adminRepo.findByEmailId(email);
        if (departmentAdminDto != null) {
            int attempts = departmentAdminDto.getFailedAttempts() + 1;
            departmentAdminDto.setFailedAttempts(attempts);
            if (attempts >= 3) {
                departmentAdminDto.setAccountLocked(true);
            }
            adminRepo.updateDepartmentAdminDetails(departmentAdminDto); // Ensure you update the changes
        }
    }

    @Override
    public int getFailedAttempts(String email) {
        DepartmentAdminDto departmentAdminDto = adminRepo.findByEmailId(email);
        if (departmentAdminDto != null) {
            return departmentAdminDto.getFailedAttempts();
        } else {
            return 0;
        }
    }



    @Override
    public void resetFailedAttempts(String email) {
        DepartmentAdminDto departmentAdminDto = adminRepo.findByEmailId(email);
        if (departmentAdminDto != null) {
            departmentAdminDto.setFailedAttempts(0);
            adminRepo.updateDepartmentAdminDetails(departmentAdminDto);
        }
    }
    @Override
    public void lockAccount(String email) {
        DepartmentAdminDto departmentAdminDto=adminRepo.findByEmailId(email);
        if(departmentAdminDto != null)
        {
            departmentAdminDto.setAccountLocked(true);
            adminRepo.updateDepartmentAdminDetails(departmentAdminDto);
        }

    }

    @Override
    public void unlockAccount(String email) {
        DepartmentAdminDto departmentAdminDto = adminRepo.findByEmailId(email);
        if (departmentAdminDto != null) {
            departmentAdminDto.setAccountLocked(false);
            adminRepo.updateDepartmentAdminDetails(departmentAdminDto);
        }

    }

    @Override
    public boolean adminForgotPassword(String email) {
        System.out.println("Running forgotPassword in ForgetPasswordServiceImpl.. ");
        DepartmentAdminDto departmentAdminDto=adminRepo.findByEmailId(email);
        if(departmentAdminDto!=null)
        {
            //Generating Random password and sending it...
            String newPassword=generatePassword();
            departmentAdminDto.setDepartmentAdminPassword(passwordEncoder.encode(newPassword));
            // signupDto.setPassword(encoder.encode(newPassword));
            adminRepo.updateDepartmentAdminDetails(departmentAdminDto);
            departmentAdminDto.setDepartmentAdminPassword(newPassword);
            //sendPassword(signupDto);
            mailSending.adminForgotPassword(departmentAdminDto);

            //Reset failed attempts
            this.resetFailedAttempts(email);
            this.unlockAccount(email);
            System.out.println("(service)Data is existing "+departmentAdminDto);

            return true;

        }
        else
        {
            System.out.println("(service) Data is not existing"+departmentAdminDto);
        }
        return false;
    }


//    @Override
//    public boolean changePassword(String email, String oldPassword, String newPassword, String confirmPassword) {
//        System.out.println("Attempting to change password for email: " + email);
//
//        // Step 1: Check if newPassword matches confirmPassword
//        if (!newPassword.equals(confirmPassword)) {
//            System.out.println("New password and confirm password do not match.");
//            return false;
//        }
//
//        // Step 2: Retrieve SignupDto based on emailId
//        DepartmentAdminDto departmentAdminDto = this.adminRepo.findByEmailId(email);
//        if (departmentAdminDto == null) {
//            System.out.println("User with email " + email + " not found.");
//            return false; // User not found
//        }
//        String storedPassword=departmentAdminDto.getDepartmentAdminPassword();
//        System.out.println(storedPassword);
//        // Step 3: Verify oldPassword matches the stored password
//        if (!passwordEncoder.matches(oldPassword, storedPassword)){
//            System.out.println("Old password verification failed for email: " + email);
//            return false; // Old password doesn't match
//        }
//
//        // Step 4: Encode and update the new password in SignupDto
//        String password=generatePassword();
//        departmentAdminDto.setDepartmentAdminPassword(passwordEncoder.encode(password));
//
//
//        // Step 5: Save the updated password in the repository
//        boolean save = adminRepo.updateDepartmentAdminDetails(departmentAdminDto);
//
//        // Step 6: Send email notification if password update was successful
//        if (save) {
//            System.out.println("Password updated successfully for email: " + email);
//            try {
//                departmentAdminDto.setDepartmentAdminPassword(password);
//                mailSending.sendAdminResetPassword(departmentAdminDto, newPassword);
//                return true; // Password successfully updated and email sent
//            } catch (MailException e) {
//                // Handle exception if email sending fails (log it or take appropriate action)
//                e.printStackTrace();
//                return false; // Indicate failure if email sending failed
//            }
//        }
//
//        return false; // Password update failed
//    }

    @Override
    public boolean changePassword(String email, String oldPassword, String newPassword, String confirmPassword) {
        System.out.println("Attempting to change password for email: " + email);

        // Step 1: Check if newPassword matches confirmPassword
        if (!newPassword.equals(confirmPassword)) {
            System.out.println("New password and confirm password do not match.");
            return false;
        }

        // Step 2: Retrieve departmentAdminDto based on emailId
        DepartmentAdminDto departmentAdminDto = this.adminRepo.findByEmailId(email);
        if (departmentAdminDto == null) {
            System.out.println("User with email " + email + " not found.");
            return false;
            // User not found
        }

        String storedPassword = departmentAdminDto.getDepartmentAdminPassword();
        System.out.println("Stored password: " + storedPassword);

        // Step 3: Verify oldPassword matches the stored password
        if (!passwordEncoder.matches(oldPassword, storedPassword)) {
            System.out.println("Old password verification failed for email: " + email);
            return false; // Old password doesn't match
        }

        // Step 4: Encode and update the new password in SignupDto
        String encodedNewPassword = passwordEncoder.encode(newPassword);
        departmentAdminDto.setDepartmentAdminPassword(encodedNewPassword);

        // Step 5: Save the updated password in the repository
        boolean save = adminRepo.updateDepartmentAdminDetails(departmentAdminDto);

        // Step 6: Send email notification if password update was successful
        if (save) {
            System.out.println("Password updated successfully for email: " + email);
            try {
                mailSending.sendAdminResetPassword(departmentAdminDto, newPassword);
                return true; // Password successfully updated and email sent
            } catch (MailException e) {
                // Handle exception if email sending fails (log it or take appropriate action)
                e.printStackTrace();
                return false; // Indicate failure if email sending failed
            }
        }

        return false; // Password update failed
    }

    @Override
    public DepartmentDto searchByDepartmentName(String departmentName) {
        System.out.println("Running searchByDepartmentName method in AdminServiceImpl... ");
        DepartmentDto departmentDto=adminRepo.searchByDepartmentName(departmentName);
        if(departmentDto!=null)
        {
            System.out.println("FindBy Department Name successfully"+departmentName);
            return departmentDto;
        }

        System.out.println("FindBy Department Name successfully"+departmentName);
        return null;
    }


//    @Override
//    public List<DepartmentAdminDto> findByUserDepartmentAdminId() {
//
//        System.out.println("findByUserDepartmentAdminId method in AdminServiceImpl..");
//        List<DepartmentAdminDto> dtoData = adminRepo.findByUserDepartmentAdminId();
//        if (dtoData != null) {
//            System.out.println("findById data successful in AdminServiceImpl..");
//            return dtoData;
//        } else {
//            System.out.println("findById data not successful in AdminServiceImpl..");
//        }
//
//        return Collections.emptyList();
//    }

    @Override
    public List<RaiseComplaintDto> findByUSerComplaintType(String complaintType) {

        System.out.println("findById method in AdminServiceImpl..");
        List<RaiseComplaintDto> dtoData = adminRepo.findByUSerComplaintType(complaintType);
        if (dtoData != null) {
            System.out.println("findByComplaintType data successful in AdminServiceImpl..");
            return dtoData;
        } else {
            System.out.println("findByComplaintType data not successful in AdminServiceImpl..");
        }

        return Collections.emptyList();
    }


}





