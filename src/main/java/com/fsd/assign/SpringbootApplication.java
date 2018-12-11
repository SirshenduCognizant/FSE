package com.fsd.assign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import com.fsd.assign.configuration.JpaConfiguration;

@Import(JpaConfiguration.class)
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringbootApplication.class, args);
	}
}
