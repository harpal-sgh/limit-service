package com.cde.microservices.limitservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cde.microservices.limitservice.bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController

public class LimitConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")	
	public LimitConfiguration retrieveLimitConfig() {
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}

	@GetMapping("/fault-tolerance") 
	@HystrixCommand(fallbackMethod = "fallbackConfig")
	public LimitConfiguration retrieveConfig() {
		throw new RuntimeException("Not Avaialable");
	}
	
	public LimitConfiguration fallbackConfig() {
		return new LimitConfiguration(9, 9999);
	}
}
