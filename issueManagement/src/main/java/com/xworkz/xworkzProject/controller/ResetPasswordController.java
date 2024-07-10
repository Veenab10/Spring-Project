package com.xworkz.xworkzProject.controller;

import com.xworkz.xworkzProject.model.service.ResetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResetPasswordController {

    @Autowired
    private ResetPasswordService resetPasswordService;

    public ResetPasswordController()
    {
        System.out.println("Created ResetPasswordController");
    }

    @PostMapping("reset-password")
    public String passwordReset(@RequestParam  String emailId, String oldPassword, String newPassword, String confirmPassword,Model model) {

        boolean resetSuccessful = resetPasswordService.changePassword(emailId, oldPassword, newPassword, confirmPassword);
        if (resetSuccessful) {
            System.out.println("Password reset Successful: " + resetSuccessful);
            model.addAttribute("passwordResetMessage", "Password reset successful");
        } else {
            model.addAttribute("passwordResetError", "Failed to reset password. Please check your password");
        }

        return "ResetPassword";
    }


//    @PostMapping("reset-password")
//    public String passwordReset(Model model, String email, String oldPassword, String newPassword, String confirmPassword) {
//
//        boolean resetSuccessful = resetPasswordService.resetPassword(email, oldPassword, newPassword, confirmPassword);
//        if (resetSuccessful) {
//            System.out.println("Password reset Successful: " + resetSuccessful);
//            model.addAttribute("passwordResetMessage", "Password reset successful");
//        } else {
//            model.addAttribute("passwordResetError", "Failed to reset password. Please check your password");
//        }
//
//        return "ResetPassword";
//    }

//    @RequestMapping("reset-password-page")
//    public String showResetPasswordPage(Model model) {
//        return "ResetPassword";
//    }
}
