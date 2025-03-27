package com.gcu.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SecurityBusinessService {
	private static final Logger logger = LoggerFactory.getLogger(SecurityBusinessService.class);
	
	public boolean authenticate(String username, String password) {
		logger.info("==========> Entering authenticate method in SecurityBusinessService");
		System.out.println("Hello from the SecurityBusinessService");
		logger.info("==========> Exiting authenticate method in SecurityBusinessService");
		return true;
	}
}
