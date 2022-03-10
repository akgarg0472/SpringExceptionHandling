package com.akgarg.springexceptionhandling.student;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Random;

@SuppressWarnings("unused")
public class Student {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final Byte rollNumber;
    private final String email;

    public Student(
            @JsonProperty("first_name") String firstName,
            @JsonProperty("last_name") String lastName,
            @JsonProperty("roll_number") Byte rollNumber,
            @JsonProperty("email") String email
    ) {
        this.email = email;
        this.id = Math.abs(new Random().nextLong());
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollNumber = rollNumber;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Byte getRollNumber() {
        return rollNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", rollNumber=" + rollNumber + ", email='" + email + '\'' + '}';
    }

}