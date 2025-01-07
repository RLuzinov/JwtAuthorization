package com.example.springtask;

import com.example.springtask.models.Status;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringtaskApplicationTests {
	private Status status;

	@Test
	void contextLoads() {
		System.out.println(status.STARTED.toString());

	}

}
