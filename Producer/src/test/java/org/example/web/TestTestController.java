//package org.example.web;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.example.model.StudentDTO;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class TestTestController {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Test
//    public void testPostStudentEndpointReturns200StatusCode() throws Exception {
//
//        StudentDTO studentDTO = new StudentDTO("ion", "test", 122);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String studentJson = objectMapper.writeValueAsString(studentDTO);
//
//        mvc.perform(MockMvcRequestBuilders.post("/test/message").content(studentJson)
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//}
