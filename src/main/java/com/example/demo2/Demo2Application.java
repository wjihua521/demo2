package com.example.demo2;

import com.example.demo2.dto.TestDto;
import com.example.demo2.service.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
		/*TestDto dto = new TestDto();
		TestService testService = new TestService();
		testService.test(dto);*/
	}

}
