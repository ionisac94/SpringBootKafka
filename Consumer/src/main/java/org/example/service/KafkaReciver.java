package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.Student;
import org.example.repo.StudentRepo;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaReciver {

	private final StudentRepo studentRepo;

	@KafkaListener(topics = "${topicName}", groupId = "${kafkaGroupId}")
	public void extractDataFromKafka(Student message) {
		System.out.println("Consumed message is: " + message);

		org.example.entity.Student student = new org.example.entity.Student();

		student.setName(message.getName());
		student.setAddress(message.getAddress());
		student.setSalary(message.getSalary());

		studentRepo.save(student);

		System.out.println("The message has been saved to DB " + message);

	}
}
