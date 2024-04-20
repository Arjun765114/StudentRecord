package com.StudentRecord.service;

import com.StudentRecord.dto.StudentDto;
import com.StudentRecord.entity.Student;
import com.StudentRecord.exception.ResourceNotFoundException;
import com.StudentRecord.mapper.StudentMapper;
import com.StudentRecord.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{
   @Autowired
   private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student saveStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(saveStudent);
    }

    @Override
    public StudentDto getStudentById(Long id) throws ResourceNotFoundException {
       Student student = studentRepository.findById(id).orElseThrow(()->
               new ResourceNotFoundException("Student with This id not Exist"+id));
       return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudent() {
         List<Student>students= studentRepository.findAll();
         return students.stream().map((student1) -> StudentMapper.mapToStudentDto(student1)).collect(Collectors.toList()
         );
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto updateStudent) throws ResourceNotFoundException {
        Student student = studentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Student with This id not Exist"+id));
          student.setFirstName(updateStudent.getFirstName());
          student.setLastName(updateStudent.getLastName());
          student.setAge(updateStudent.getAge());
          student.setGender(updateStudent.getGender());
          student.setPhone_no(updateStudent.getPhone_no());

        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public void deleteStudent(Long id) throws ResourceNotFoundException {
       Student student = studentRepository.findById(id).orElseThrow(()->
               new ResourceNotFoundException("Student with This id not Exist"+id));
         studentRepository.deleteById(id);
    }
}
