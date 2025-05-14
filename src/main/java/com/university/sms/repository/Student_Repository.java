package com.university.sms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.sms.controller.Student;

public interface Student_Repository extends JpaRepository<Student,Long>{

    Optional<Student> findByEmail(String email);

}
