package com.sai.SpringBootLearnAll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootLearnAllApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLearnAllApplication.class, args);
	}

}
