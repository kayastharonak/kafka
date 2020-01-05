package com.kafka.util;

import java.util.Set;
import java.util.concurrent.ExecutionException;

public interface KafkaUtil {

	public Set<String> getTopics() throws InterruptedException, ExecutionException;
}
