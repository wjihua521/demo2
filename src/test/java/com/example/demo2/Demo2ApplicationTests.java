package com.example.demo2;

import com.example.demo2.dto.TestDto;
import com.example.demo2.dto.UserInfoDto;
import com.example.demo2.service.MyAnnotationTestService;
import com.example.demo2.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo2ApplicationTests {
	@Autowired
	private MyAnnotationTestService testService;

	@Test
	public void contextLoads() {
		testService.test1();
		UserInfoDto dto = new UserInfoDto();
		dto.setOpenid(UUID.randomUUID().toString());
		testService.test2(dto);
		TestDto dto2 = new TestDto();
		dto2.setName("帝释天");
		testService.test3(dto2);

		dto.setOpenid(UUID.randomUUID().toString());
		testService.test4(dto,"test4");
	}

}
