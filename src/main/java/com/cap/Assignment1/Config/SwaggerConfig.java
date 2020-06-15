package com.cap.Assignment1.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("Capgemini Assignment").description("This is page for document all the API info").version("2.0").contact(new Contact("Ajith Kumar", "https://www.capgemini.com", "ajith-kumar.a.t@capgemini.com")).license("License 3.0").licenseUrl("https://www.").build();
	}
}
