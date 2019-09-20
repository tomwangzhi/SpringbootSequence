package com.wz.springboot;

import com.wz.springboot.util.MongoUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class SpringbootMongoApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongoApplication.class, args);
		MongoUtil.createDefaulCollection("user");
	}

}
