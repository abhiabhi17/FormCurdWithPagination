package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.appproperties.AppProperties;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableConfigurationProperties(AppProperties.class)
public class FormCurdWithPaginationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormCurdWithPaginationApplication.class, args);
	}

}
