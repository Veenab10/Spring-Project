package com.xworkz.xworkzProject.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
@EnableWebMvc
public class IssueManagementWebInit  extends AbstractAnnotationConfigDispatcherServletInitializer  implements WebMvcConfigurer {

    public IssueManagementWebInit()
    {
        System.out.println("Created IssueManagementWebInit");
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("Running getServletMappings..");
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("Running getRootConfigClasses..");
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("Running getServletConfigClasses..");
        return new Class[]{IssueManagementPrimaryConfiguration.class};
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
        configurer.enable();
    }
}
