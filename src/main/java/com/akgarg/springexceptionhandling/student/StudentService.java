package com.akgarg.springexceptionhandling.student;

import com.akgarg.springexceptionhandling.exception.exceptions.RequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

// Dummy Student service class
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    // method to fetch all students
    List<Student> getAllStudents() {
        return studentRepository.fetchAllStudents();
    }


    // method to save new student
    ResponseEntity<Student> saveStudent(Student student) {
        validateStudentData(student);

        if (studentRepository.isStudentExists(student)) {
            throw new RequestException("Student already exists in database. " + student);
        }

        boolean persistStudent = this.studentRepository.persistStudent(student);

        return persistStudent ? new ResponseEntity<>(student, HttpStatus.CREATED) : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }


    // method to validate the data of student
    private void validateStudentData(Student student) {
        if (student.getLastName() == null) {
            throw new RequestException("Last name is mandatory");
        }
        if (student.getRollNumber() == null) {
            throw new RequestException("Please provide roll number");
        }
        if (student.getEmail() == null || student.getEmail().trim().isEmpty()) {
            throw new RequestException("Please provide valid email");
        }
    }

}
