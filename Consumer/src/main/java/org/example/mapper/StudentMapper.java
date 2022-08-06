package org.example.mapper;

import org.example.entity.Student;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {

    Student toStudentDTO(Student student);

}
