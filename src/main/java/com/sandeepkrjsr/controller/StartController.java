package com.sandeepkrjsr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {

	/**
	 * This method it the starting endpoint
	 * Webapp starts from here.
	 * @return String
	 */
	@GetMapping("/")
	public String homePage() {
		return "Hello World";
	}
	
	
	/**
	 * This endpoint is for testing purpose only.
	 * To check apis are working or not
	 * @return String
	 */
	@GetMapping("/endpoint")
	public String endpoint() {
		return "This is the endpoint";
	}
	
}
