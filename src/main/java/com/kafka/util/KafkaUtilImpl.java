package com.kafka.util;

import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
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

}
