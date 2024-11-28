package com.pace.app.lesson12_simple_crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Lesson1SimpleCrmApplication {

	private static final Logger logger = LoggerFactory.getLogger(Lesson1SimpleCrmApplication.class);
	public static void main(String[] args) {
		// logger.info("🟢 Starting MySpringbootProjectApplication");
		// logger.warn("🟠 Test Warning");
		// logger.error("🔴 Error Warning");
		SpringApplication.run(Lesson1SimpleCrmApplication.class, args);
	}

}
