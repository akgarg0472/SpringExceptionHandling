package com.akgarg.springexceptionhandling.student;

import com.akgarg.springexceptionhandling.exception.exceptions.DatabaseException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

// Dummy Student Repository class
@Repository
public class StudentRepository {

    // method to fetch all students from the DB
    List<Student> fetchAllStudents() {
        if (new Random().nextBoolean()) {
            throw new DatabaseException("Error fetching students data from database");
        }

        return List.of(new Student("John", "Doe", (byte) 11, "johndoe11@email.com"), new Student("Joe", "Bloggs", (byte) 5, "joebloggs5@email.com"), new Student("Juan", "Perez", (byte) 1, "juanperez1@email.com"));
    }


    // method which interacts with actual DB to store new student
    boolean persistStudent(Student student) {
        return student != null;
    }


    // method to check if students already exists in the database or not
    boolean isStudentExists(Student student) {
        return new Random().nextBoolean();
    }


}
