package org.example.mapper;

import org.example.entity.Student;
import org.example.model.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper STUDENT_MAPPER = Mappers.getMapper(StudentMapper.class);

    StudentDTO toStudentDTO(Student student);

    Student toStudent(StudentDTO studentDTO);

}
