package com.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;

public class ProducerConfig {

	public static KafkaProducer<Long, String> getConsumer() {
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("client.id", "kafka-client-1");
		return new KafkaProducer<>(properties);
	}

}
