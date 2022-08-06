package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.StudentDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class KafkaSender {

	private final KafkaTemplate<String, StudentDTO> kafkaTemplate;

	@Value("${topicName}")
	private String topicName;

	public void sendDataToKafka(StudentDTO student) {
		Map<String, Object> headers = new HashMap<>();
		headers.put(KafkaHeaders.TOPIC, topicName);
		kafkaTemplate.send(new GenericMessage<>(student, headers));
	}

}
