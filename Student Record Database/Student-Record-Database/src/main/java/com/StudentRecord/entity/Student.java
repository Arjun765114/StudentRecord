package com.StudentRecord.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Students")
public class Student {

    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name ="first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "student_Gender")
    String gender;

    @Column(name = "student_age")
    int age;

    @Column(name = "student_Phone")
    Long phone_no;



}
