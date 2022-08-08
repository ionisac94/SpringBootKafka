package org.example.web;

import lombok.RequiredArgsConstructor;
import org.example.model.StudentDTO;
import org.example.service.KafkaSenderStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class StudentController {

    private final KafkaSenderStudentService kafkaSender;


    @PostMapping(value = "/message", consumes = MediaType.APPLICATION_JSON_VALUE,
                                     produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getText(@RequestBody StudentDTO student) {
        kafkaSender.sendDataToKafka(student);
        System.out.println("Produced message is: " + student);
        return new ResponseEntity<>("The data was send to Kafka", HttpStatus.OK);
    }
}
