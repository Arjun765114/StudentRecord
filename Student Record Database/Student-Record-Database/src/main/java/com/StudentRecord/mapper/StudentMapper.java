package com.StudentRecord.mapper;

import com.StudentRecord.dto.StudentDto;
import com.StudentRecord.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(student.getId(), student.getFirstName(), student.getLastName(), student.getGender(),
                student.getAge(), student.getPhone_no());
    }

    public static Student mapToStudent(StudentDto studentDto){
        return  new Student(studentDto.getId(), studentDto.getFirstName(), studentDto.getLastName(), studentDto.getGender(),
                studentDto.getAge(), studentDto.getPhone_no());
    }
}

