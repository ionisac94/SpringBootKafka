package org.example.service;

import org.example.model.Student;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaReciver {

	@KafkaListener(topics = "${topicName}", groupId = "${kafkaGroupId}")
	public void extractDataFromKafka(Student message) {
		System.out.println("Consumed message is: " + message);
	}
}
