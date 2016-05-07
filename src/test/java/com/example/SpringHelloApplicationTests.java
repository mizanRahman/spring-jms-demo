package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringHelloApplication.class)
@WebAppConfiguration
public class SpringHelloApplicationTests {

	@Autowired
	private SecureSessionStore secureSessionStore;

	@Test
	public void contextLoads() {
		secureSessionStore.put("mykey", "myvalue");
	}

}
