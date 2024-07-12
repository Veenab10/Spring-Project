package com.xworkz.xworkzProject.controller;

import com.xworkz.xworkzProject.dto.ImageUploadDto;
import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.repo.ImageUploadRepo;
import com.xworkz.xworkzProject.model.service.EditUserProfileService;
import com.xworkz.xworkzProject.model.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("")
@SessionAttributes("signupDto") // Specify the model attribute to be stored in session
public class EditUserProfileController {

    @Autowired
    private EditUserProfileService editUserProfileService;

    @Autowired
    private HttpSession httpSession;


    @GetMapping("/edit-profile")
    public String showUserDetails(Model model) {
        String userEmail = (String) httpSession.getAttribute("signedInUserEmail");
        System.out.println("Signed-in user email: " + userEmail);

        if (userEmail != null) {
            SignupDto dto = (SignupDto) model.getAttribute("signupDto"); // Retrieve from model
            if (dto == null) {
                // If signupDto is not in session, fetch it from service (though ideally, it should be set during sign-in)
                dto = editUserProfileService.findByEmailId(userEmail);
                model.addAttribute("signupDto", dto); // Add to model for session attributes
            }
            model.addAttribute("signupdto", dto); // Make sure the attribute name matches what is used in JSP
        } else {
            System.out.println("User email not found in session.");
            // Handle session expired or not signed in
        }

        return "EditUserProfile"; // Return the name of your JSP file
    }

    // Add update profile functionality if required


//    @PostMapping("/edit-profile")
//    public String editUser(SignupDto signupDto, Model model) {
//        SignupDto updatedUser = editUserProfileService.updateSignupDtoByEmailId(signupDto);
//        if (updatedUser != null) {
//            // model.addAttribute("signupDto", updatedUser);
//            model.addAttribute("signupDto", updatedUser);
//            System.out.println("SignupDto Details:"+signupDto);
//            model.addAttribute("profileMessage", "Profile updated successfully");
//            return "EditUserProfile";
//           // return "HomePage";
//        }
//        model.addAttribute("profileError", "Error updating profile");
//        return "HomePage";
//    }

//    @PostMapping("/edit-profile") //in this image also uploading
//    public String updateUserProfile(SignupDto signupDto, Model model, @RequestParam("file") MultipartFile file, HttpSession httpSession) {
//        try {
//            if (file != null && !file.isEmpty()) {
//                String originalFilename = file.getOriginalFilename();
//                String newFileName = signupDto.getEmailId() + "_" + originalFilename;
//                Path path = Paths.get(UPLOAD_DIR, newFileName);
//                //log.info("path: {}", path);
//                System.out.println("Path:"+path);
//                Files.write(path, file.getBytes());
//                signupDto.setImageName(newFileName);
//
//                // Save image details in database
//                ImageUploadDto imageUploadDto = new ImageUploadDto();
//                imageUploadDto.setSignupDto(signupDto); // Set the user
//                //imageUploadDto.setImagePath(newFileName); // Set the image path
//                imageUploadDto.setImageName(originalFilename);
//                imageUploadDto.setImageSize(file.getSize());
//                imageUploadDto.setImageType(file.getContentType());
//                // editProfileImageDTO.setUser(user);
//                //imageUploadDto.setCreatedBy(String.valueOf(LocalDateTime.now()));
////                ditProfileImageDTO.setUser(signUpDTO); // Set the user
////                editProfileImageDTO.setImagePath(newFileName); // Set the image path
////                editProfileImageDTO.setImageName(originalFilename); // Set the original filename as imageName
//                //imageUploadService.saveImageDetails(editProfileImageDTO);
//                //imageUploadService.saveImageDetails(editProfileImageDTO); // Save image details
//                imageUploadRepo.saveProfileImage(imageUploadDto);
//            }
//
//            SignupDto updatedUserData = editUserProfileService.updateSignupDtoByEmailId(signupDto);
//            if (updatedUserData != null) {
//                model.addAttribute("signUpDTO", updatedUserData);
//                model.addAttribute("msg", "Profile updated successfully");
//
//
//                //display in console
//                //log.info("Image upload");
//                System.out.println("Image upload");
//                //log.info("file getName: {}", file.getName());
//                System.out.println("file getName:"+file.getName());
//                // log.info("file getSize: {}", file.getSize());
//                //log.info("file getContentType: {}", file.getContentType());
//                System.out.println("file getContentType:"+file.getContentType());
//                //log.info("file getResource: {}", file.getResource());
//                System.out.println("file getResources:"+file.getResource());
//                // log.info("file getBytes: {}", file.getBytes());
//                //log.info("file getOriginalFilename: {}", file.getOriginalFilename());
//                System.out.println("file getOriginalName:"+file.getOriginalFilename());
//                //log.info("File uploaded: {}, ContentType: {}", file.getOriginalFilename(), file.getContentType());
//                System.out.println("file uploaded:"+file.getOriginalFilename()+"Content Type:"+file.getContentType());
//                return "EditUserProfile"; // Redirect to edit profile page
//            } else {
//                model.addAttribute("errorMessage", "Error updating profile");
//            }
//        } catch (IOException e) {
//            model.addAttribute("errorMessage", "Error uploading file: " + e.getMessage());
//            //log.error("Error uploading file", e);
//            System.out.println("Error uploading file"+e);
//        }
//
//        return "HomePage"; // Handle error or success case
//    }
}


