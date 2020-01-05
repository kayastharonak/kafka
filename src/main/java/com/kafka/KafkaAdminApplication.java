package com.kafka;

import java.util.concurrent.ExecutionException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaAdminApplication {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		SpringApplication.run(KafkaAdminApplication.class, args);
	}

}
