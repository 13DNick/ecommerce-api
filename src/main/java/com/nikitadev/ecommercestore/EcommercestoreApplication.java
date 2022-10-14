package com.nikitadev.ecommercestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class EcommercestoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommercestoreApplication.class, args);
	}

}
