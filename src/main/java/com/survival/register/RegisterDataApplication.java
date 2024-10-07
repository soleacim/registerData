package com.survival.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegisterDataApplication {

	static {
		// Enable Netty Http Server access log
		System.setProperty("reactor.netty.http.server.accessLogEnabled", "true");
	}

	public static void main(String[] args) {
		SpringApplication.run(RegisterDataApplication.class, args);
	}

}
