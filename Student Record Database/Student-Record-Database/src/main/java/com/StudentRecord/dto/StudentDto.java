package com.StudentRecord.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    Long id;

    String firstName;

    String lastName;

    String gender;

    int age;

    Long phone_no;

}
