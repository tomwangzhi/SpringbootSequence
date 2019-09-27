package com.wz.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan  // 开启Servlet注解方式的
public class SpringbootServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServletApplication.class, args);
	}

}
