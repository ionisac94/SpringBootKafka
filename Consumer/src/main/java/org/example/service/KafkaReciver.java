package org.example.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaReciver {

	@KafkaListener(topics = "${topicName}", groupId = "${kafkaGroupId}")
	public void sendDataFromKafka(String message) {
		System.out.println("Consumed message is: " + message);
	}
}
