package org.example.web;

import org.example.model.StudentDTO;
import org.example.service.KafkaSenderStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {

	@InjectMocks
	private StudentController studentController;

	@Mock
	private KafkaSenderStudentService kafkaSender;

	@Test
	public void testPostStudentEndpointReturns200StatusCode() throws Exception {

		// GIVEN
		StudentDTO studentDTO = new StudentDTO("ion", "test", 122);

		// WHEN
		Mockito.doNothing().when(kafkaSender).sendDataToKafka(studentDTO);

		// THEN
		ResponseEntity<Object> responseEntity = studentController.getText(studentDTO);

		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		verify(kafkaSender, times(1)).sendDataToKafka(studentDTO);


	}

}
