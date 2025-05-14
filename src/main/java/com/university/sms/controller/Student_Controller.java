package com.university.sms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.sms.service.IStudent_Service;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class Student_Controller {
   private final IStudent_Service student_Service;

   @GetMapping
   public ResponseEntity<List<Student>> getStudents(){

    return new ResponseEntity<>(student_Service.getStudents(),HttpStatus.FOUND);
   }
}
