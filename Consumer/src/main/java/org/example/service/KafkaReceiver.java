package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Student;
import org.example.mapper.StudentMapper;
import org.example.model.StudentDTO;
import org.example.repo.StudentRepo;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaReceiver {

	private final StudentRepo studentRepo;

	@KafkaListener(topics = "${topicName}", groupId = "${kafkaGroupId}")
	public void extractDataFromKafka(StudentDTO studentDTO) {
		System.out.println("Consumed message is: " + studentDTO);

		StudentMapper studentMapper = StudentMapper.STUDENT_MAPPER;

		Student student = studentMapper.toStudent(studentDTO);

		studentRepo.save(student);

		System.out.println("The message has been saved to DB " + student);

	}
}
