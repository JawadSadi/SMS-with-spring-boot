package com.university.sms.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.sms.service.IStudent_Service;

import lombok.RequiredArgsConstructor;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class Student_Controller {
   private final IStudent_Service student_Service;



   @PostMapping
   public Student addStudent(@RequestBody Student student){
      return student_Service.addStudent(student);
   }

   @GetMapping
   public ResponseEntity<List<Student>> getStudents(){
    return new ResponseEntity<>(student_Service.getStudents(),HttpStatus.FOUND);
   }

   

   @PutMapping("/update/{id}")
   public Student updatStudent(@RequestBody Student student,@PathVariable Long id){
      return student_Service.updateStudent(student,id);
   }

   @DeleteMapping("/delete/{id}")
   public void  deleteStudent(@PathVariable Long id){
       student_Service.deleteStudent(id);
   }

   @GetMapping("/student/{id}")
   public Student getStudentById(@PathVariable Long id){
      return student_Service.getStudentById(id);
   }
}
