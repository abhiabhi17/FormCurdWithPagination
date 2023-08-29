package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	
	public Docket docket()
	{
		 return new Docket(DocumentationType.SWAGGER_2).select()
		            .apis(RequestHandlerSelectors
		                .basePackage("com.example.rest"))
		            .paths(PathSelectors.any())
		            .build().apiInfo(apiInfo());
	}
	
public ApiInfo apiInfo()
{
	Contact contact=new Contact("abhi", "www.example.com", "abhi@gmail.com");
	 ApiInfo info=new ApiInfo("SB-App", "Testting", "1.0", "www.abhi.com", contact, "Apache", "apache.org");
	 
	 
	 return info;
	
	
}
}
