package com.instaclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InstacloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstacloneApplication.class, args);
	}

}
