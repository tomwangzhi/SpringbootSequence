package com.intellif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ShenzhenStaticImportApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShenzhenStaticImportApplication.class, args);
	}

}
