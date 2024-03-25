package com.sai.SpringBootLearnAll;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootLearnAllApplicationTests {

	@LocalServerPort
	private int port;


	private String baseUrl = "http://localhost:";

	private static RestTemplate restTemplate;


	@BeforeAll
	public static  void init(){
		restTemplate = new RestTemplate();
	}


	@BeforeEach
	public void setUp(){
		baseUrl = baseUrl + port + "" ;
	}


//	@Test
//	public void test

}
