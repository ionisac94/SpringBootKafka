package org.example.web;

import lombok.RequiredArgsConstructor;
import org.example.model.Student;
import org.example.service.KafkaSender;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

	private final KafkaSender kafkaSender;


	@PostMapping("/{message}")
	public ResponseEntity<Object> getText(@RequestBody Student student) {
		kafkaSender.sendDataToKafka(student);
		System.out.println("Produced message is: " + student);
		return new ResponseEntity<>("Data was send to Kafka", HttpStatus.OK);
	}
}
