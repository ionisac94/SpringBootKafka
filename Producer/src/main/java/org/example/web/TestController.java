package org.example.web;

import lombok.RequiredArgsConstructor;
import org.example.service.KafkaSender;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

	private final KafkaSender kafkaSender;

	@GetMapping("/{message}")
	public String getText(@PathVariable final String message) {
		kafkaSender.sendDataToKafka(message);
		System.out.println("Returned value is: " + message);
		return message;
	}

}
