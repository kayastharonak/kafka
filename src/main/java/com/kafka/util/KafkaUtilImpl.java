package com.kafka.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaUtilImpl implements KafkaUtil {

	private final AdminClient adminClient;

	@Autowired
	public KafkaUtilImpl(AdminClient adminClient) {
		this.adminClient = adminClient;
	}

	@Override
	public Set<String> getTopics() throws InterruptedException, ExecutionException {
		ListTopicsResult topics = adminClient.listTopics();
		return topics.names().get();
	}

	@Override
	public boolean createTopic(String topicName) {
		ArrayList<NewTopic> topics = createNewTopic(topicName);
		adminClient.createTopics(topics);
		return true;
	}

	@Override
	public boolean deleteTopic(String topicName) {
		List<String> topics = new ArrayList<>();
		topics.add(topicName);
		adminClient.deleteTopics(topics);
		return true;
	}

	private ArrayList<NewTopic> createNewTopic(String topicName) {
		NewTopic newTopic = new NewTopic(topicName, 1, (short) 1);
		ArrayList<NewTopic> topics = new ArrayList<>();
		topics.add(newTopic);
		return topics;
	}

}
