package com.university.sms.service;

import java.util.List;

import com.university.sms.controller.Student;

public interface IStudent_Service {


    // method for adding student
    Student addStudent(Student student);
    // List of students
    List<Student> getStudents();
    // method for updating the student 
    Student updateStudent(Student student,long id);

    Student getStudentById(long id);

    void deleteStudent(long id);
}
