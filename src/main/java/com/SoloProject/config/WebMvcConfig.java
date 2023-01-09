package com.SoloProject.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//@EnableWebMvc
@Configuration
@ComponentScan({"com.SoloProject", "com.SoloProject.config", "com.SoloProject.controllers"
	, "com.SoloProject.model", "com.SoloProject.repository", "com.SoloProject.service", 
	"com.SoloProject.setup"})
public class WebMvcConfig implements WebMvcConfigurer{

	@Bean
	public ViewResolver viewResolverBean() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("css/**").addResourceLocations("/WEB-INF/css/");
	    registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/img/")
        .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
		
	}
}
