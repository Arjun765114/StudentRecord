package com.StudentRecord.controller;

import com.StudentRecord.dto.StudentDto;
import com.StudentRecord.exception.ResourceNotFoundException;
import com.StudentRecord.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<StudentDto> SaveStudent(@RequestBody StudentDto studentDto){
        StudentDto studentDto1 = studentService.createStudent(studentDto);
        return new ResponseEntity<>(studentDto1, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long id) throws ResourceNotFoundException {
        StudentDto studentDto = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto>studentDtos = studentService.getAllStudent();
        return ResponseEntity.ok(studentDtos);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> updateStudentInfo(@PathVariable Long id,@RequestBody StudentDto updateStudent) throws ResourceNotFoundException {
        StudentDto studentDto = studentService.updateStudent(id,updateStudent);
        return ResponseEntity.ok(studentDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudentInfo(@PathVariable Long id) throws ResourceNotFoundException {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student Info SuccessFully Deleted");
    }


}
