package com.sns.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sns.common.FileManagerService;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(
			ResourceHandlerRegistry registry) {
		
		registry
		.addResourceHandler("/images/**") // web의 주소 path => http://localhost/images/aaaa_1721209542485/plant-8612513_1280.jpg
		.addResourceLocations("file:///" + FileManagerService.FILE_UPLOAD_PATH); // 실제 이미지 파일 위치 
	}
	
}
