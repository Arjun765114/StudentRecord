package com.StudentRecord.service;

import com.StudentRecord.dto.StudentDto;
import com.StudentRecord.exception.ResourceNotFoundException;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long id) throws ResourceNotFoundException;

    List<StudentDto> getAllStudent();

    StudentDto updateStudent(Long id,StudentDto updateStudent) throws ResourceNotFoundException;

    void deleteStudent(Long id) throws ResourceNotFoundException;



}
