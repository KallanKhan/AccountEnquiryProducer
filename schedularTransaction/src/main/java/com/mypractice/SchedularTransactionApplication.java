package com.mypractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedularTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedularTransactionApplication.class, args);
	}

}
