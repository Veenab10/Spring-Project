package com.xworkz.xworkzProject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.xworkzProject")
@PropertySource("classpath:application.properties")
@EnableWebMvc
public class IssueManagementPrimaryConfiguration implements WebMvcConfigurer {

    public IssueManagementPrimaryConfiguration()
    {
        System.out.println("Created IssueManagementPrimaryConfiguration");
    }

    @Bean
    public ViewResolver viewResolver(){
        System.out.println("Created ViewResolver");
        return new InternalResourceViewResolver("/",".jsp");
    }



   @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        System.out.println("Adding resource handlers");
        //WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/js/**").addResourceLocations("/javaScript/");
        //set path for image display
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:///C:/Users/VEENA/Desktop/uploadImage/");
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("utf-8");
        multipartResolver.setMaxUploadSize(10485760); // 10MB
        return multipartResolver;
    }

    //For Encrypting
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
