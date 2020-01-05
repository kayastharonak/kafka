package com.client;

import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.util.KafkaUtil;

@RestController
@RequestMapping(value = "/kafka")
public class ConsumerController {

	private final KafkaUtil kafkaUtil;

	@Autowired
	public ConsumerController(KafkaUtil kafkaUtil) {
		this.kafkaUtil = kafkaUtil;
	}

	@GetMapping
	public Set<String> getTopics() throws InterruptedException, ExecutionException {
		return kafkaUtil.getTopics();
	}

	@PostMapping(value = "/{topicName}")
	public boolean createTopic(@PathVariable("topicName") String topicName) {
		return kafkaUtil.createTopic(topicName);
	}

	@DeleteMapping(value = "/{topicName}")
	public boolean deleteTopic(@PathVariable("topicName") String topicName) {
		return kafkaUtil.deleteTopic(topicName);
	}

}
