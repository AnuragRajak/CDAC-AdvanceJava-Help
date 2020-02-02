package com.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource("classpath:test.properties")
@ConfigurationProperties(prefix = "download")
public class Config implements WebMvcConfigurer {
	private String location;
	public Config() {
		System.out.println("in config constr");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("in add res handler "+location);
		registry.addResourceHandler("/**").addResourceLocations(location);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		System.out.println("in add view controller");
		registry.addViewController("/").setViewName("index");
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	

}
