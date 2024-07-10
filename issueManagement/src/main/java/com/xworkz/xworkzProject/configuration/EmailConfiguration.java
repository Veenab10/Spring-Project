package com.xworkz.xworkzProject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
    public class EmailConfiguration {

        public EmailConfiguration()
        {
            System.out.println("Created EmailConfiguration");
        }

        @Bean
        public JavaMailSender getJavaMailSender() {
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("smtp.gmail.com.");// Replace with your SMTP host
            mailSender.setPort(587); // Replace with your SMTP port like 25,465,2525
            mailSender.setUsername("veenabaligeri10@gmail.com");
            mailSender.setPassword("xdgl zfkw nxtr buie");//App Password from Google account(2 step verification)

            Properties props = mailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.debug", "true");

            return mailSender;
        }
    }


