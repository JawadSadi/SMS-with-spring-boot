package com.university.sms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.university.sms.controller.Student;
import com.university.sms.exception.StudentAlreadyExistsException;
import com.university.sms.exception.StudentNotFoundException;
import com.university.sms.repository.Student_Repository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class Student_Service implements IStudent_Service{

private final Student_Repository student_Repository;

@Override
public List<Student> getStudents() {
    return student_Repository.findAll();
    
}

    @Override
    public Student addStudent(Student student) {

        if(studentAlreadyExists(student.getEmail())){
            throw new StudentAlreadyExistsException(student.getEmail()+"already exists!");
        }
        
        return student_Repository.save(student);
    }
    
    @Override
    public Student updateStudent(Student student, long id) {
        return student_Repository.findById(id)
                .map(st -> {
                    st.setFirstName(student.getFirstName());
                    st.setLastName(student.getLastName());
                    st.setEmail(st.getEmail());
                    st.setDepartment(st.getDepartment());
                    return student_Repository.save(st);
                })
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }


    @Override
    public Student getStudentById(long id) {
       return student_Repository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student not found with this Id :" + id));
    }

    @Override
    public void deleteStudent(long id) {
        if(!student_Repository.existsById(id)){
            throw new StudentNotFoundException("Student not found");
        }
    }


    private boolean studentAlreadyExists(String email) {
        return student_Repository.findByEmail(email).isPresent();
    }
}
