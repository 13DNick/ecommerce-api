package com.nikitadev.ecommercestore;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableSwagger2
public class EcommercestoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommercestoreApplication.class, args);
	}

	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/**"))
				.apis(RequestHandlerSelectors.basePackage("com.nikitadev"))
				.build()
				.apiInfo(this.getDetails());
	}
	
	private ApiInfo getDetails() {
		return new ApiInfo(
				"Ecommerce Store API",
				null,
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Nikita Koulaga", null, "nikitakoulaga@gmail.com"),
				null,
				null,
				Collections.emptyList());
	}
}
