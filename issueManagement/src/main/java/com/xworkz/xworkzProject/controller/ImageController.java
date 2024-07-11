package com.xworkz.xworkzProject.controller;

import com.xworkz.xworkzProject.dto.ProfileImageDto;
import com.xworkz.xworkzProject.dto.SignupDto;
import com.xworkz.xworkzProject.model.service.EditUserProfileService;
import com.xworkz.xworkzProject.model.service.ProfileImageService;
;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("")
@RestController
public class ImageController {

    @Autowired
    private ProfileImageService profileImageService;

    @Autowired
    private EditUserProfileService editUserProfileService;

    public ImageController()
    {
        System.out.println("Created ImageController");
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam MultipartFile file, ProfileImageDto profileImageDto, SignupDto signupDto, Model model) throws IOException {
        System.out.println("Running uploadImage method in ImageController ");
        boolean saved=profileImageService.saveAndValidate(profileImageDto);
        if(saved)
        {
            SignupDto updatedUser = editUserProfileService.updateSignupDtoByEmailId(signupDto);
            if (updatedUser != null) {
                // model.addAttribute("signupDto", updatedUser);
                model.addAttribute("signupDto", updatedUser);
                System.out.println("SignupDto Details:"+signupDto);
                model.addAttribute("profileMessage", "Profile updated successfully");
                return "EditUserProfile";
                // return "HomePage";
            }
            model.addAttribute("profileError", "Error updating profile");
            //httpSession.setAttribute("signedInUserEmail",profileImageDto);
            System.out.println("saved  service in controller"+profileImageDto);
        }
        else {
            System.out.println("not saved service in controller"+profileImageDto);
        }

        System.out.println("Image upload");
        System.out.println("file getName"+file.getName());
        System.out.println("file getSize"+file.getSize());
        System.out.println("file getContentType"+file.getContentType());
        System.out.println("file getResource"+file.getResource());
        System.out.println("file getBytes"+file.getBytes());
        System.out.println("file getOriginalFilename"+file.getOriginalFilename());


        byte[] bytes=file.getBytes();
        Path path= Paths.get("C:\\Users\\VEENA\\Desktop\\uploadImage",file.getOriginalFilename());
        Files.write(path,bytes);

        System.out.println("fileName:"+file.getOriginalFilename()+"ContentType:"+file.getContentType());
        return "HomePage";

    }
}

