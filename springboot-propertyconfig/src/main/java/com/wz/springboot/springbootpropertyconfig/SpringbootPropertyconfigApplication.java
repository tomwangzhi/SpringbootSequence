package com.wz.springboot.springbootpropertyconfig;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class SpringbootPropertyconfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootPropertyconfigApplication.class, args);

		// 这里可以获取通过CommandLineRunner方式设置的属性
		System.out.println(System.getProperty("key"));
		// 取程序运行时传进来的变量
		System.out.println(System.getenv("a"));
		System.out.println(System.getenv("b"));
	}

	// 通过该种方式往系统设置属性
	@Bean
	public CommandLineRunner commandLineRunner() {
		// 匿名接口实现缩写方式(args)类似new CommandLineRunner 然后实现接口的run方法
		return (args)->{
			System.setProperty("key", "test12");
		};
	}

}
