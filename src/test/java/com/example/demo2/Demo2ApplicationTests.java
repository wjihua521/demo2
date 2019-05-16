package com.example.demo2;

import com.example.demo2.dto.TestDto;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo2ApplicationTests {
	@Autowired
	private TestService testService;

	@Test
	public void contextLoads() {
		TestDto dto = MyApplicationContextUtil.getBeanByType(TestDto.class);
		dto.setAddress("3");
		dto.setName("北京");
		testService.test(dto);
	}

}
