package org.example.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KafkaSender {

	private final KafkaTemplate<String, String> kafkaTemplate;

	@Value("${topicName}")
	private String topicName;

	public void sendDataToKafka(String message) {
		kafkaTemplate.send(new ProducerRecord<>(topicName, message));
	}

}
