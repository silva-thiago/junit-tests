package com.contactmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@SpringBootTest
class ContactManagerApplicationTests {
	@Test
	@DisplayName("Should be able to verify that the app runs successfully within the 5 second timeout")
	void contextLoads() {
		Assertions.assertTimeout(Duration.ofSeconds(5), () -> {
			// TODO: test
		});
	}
}
