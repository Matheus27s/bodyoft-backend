package com.playground.bodyoft.services;

import com.playground.bodyoft.models.StudentModel;

import java.util.UUID;

public interface StudentService {
    StudentModel saveStudent(StudentModel student);

    StudentModel getOneStudent(UUID studentId);
}
