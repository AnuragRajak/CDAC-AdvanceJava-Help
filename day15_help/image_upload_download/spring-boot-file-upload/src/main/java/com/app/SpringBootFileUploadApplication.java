package com.app;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.app.controllers.FileUploadController;

@SpringBootApplication
public class SpringBootFileUploadApplication /*implements WebMvcConfigurer*/{

	public static void main(String[] args) {
		System.out.println("dir created "+new File(FileUploadController.uploadLocation).mkdir());
		SpringApplication.run(SpringBootFileUploadApplication.class, args);
	}
	//instead of adding here --created a separate configuration class
	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("setting resources");
		registry.addResourceHandler("/**").addResourceLocations("file:/e:/images/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addViewControllers(registry);
	}*/
	
	

}
