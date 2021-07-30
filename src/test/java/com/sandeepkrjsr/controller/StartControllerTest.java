package com.sandeepkrjsr.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StartControllerTest {
	
	StartController controller;
	
	@BeforeEach
	void setup() {
		controller = new StartController();
	}
	
	@Test
	void testHomePage() {
		String output = controller.homePage();
		assertEquals("Hello World", output);
	}
	
	@Test
	void testEndpoint() {
		String output = controller.endpoint();
		assertEquals("This is the endpoint", output);
	}

}
