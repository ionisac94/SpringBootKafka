package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Student;
import org.example.model.StudentDTO;
import org.example.repo.StudentRepo;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaReceiver {

	private final StudentRepo studentRepo;

	@KafkaListener(topics = "${topicName}", groupId = "${kafkaGroupId}")
	public void extractDataFromKafka(StudentDTO message) {
		System.out.println("Consumed message is: " + message);

		Student student = new Student();

		student.setName(message.getName());
		student.setAddress(message.getAddress());
		student.setSalary(message.getSalary());

		studentRepo.save(student);

		System.out.println("The message has been saved to DB " + student);

	}
}
