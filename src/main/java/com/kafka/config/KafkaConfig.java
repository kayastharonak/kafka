package com.kafka.config;

import java.util.Properties;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "kafka_admin-config.yml")
public class KafkaConfig {

	@Bean
	public AdminClient adminClient(Environment environment) {
		Properties properties = new Properties();
		properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(AdminClientConfig.CLIENT_ID_CONFIG, environment.getProperty("client-id"));
		return AdminClient.create(properties);
	}
}
