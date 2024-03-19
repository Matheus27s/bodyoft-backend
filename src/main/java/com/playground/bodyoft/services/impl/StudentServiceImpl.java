package com.playground.bodyoft.services.impl;

import com.playground.bodyoft.models.StudentModel;
import com.playground.bodyoft.repositories.StudentRepository;
import com.playground.bodyoft.services.StudentService;
import com.playground.bodyoft.services.exceptions.EntityNotFoundException;
import com.playground.bodyoft.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentRepository studentRepository;

    @Override
    @Transactional
    public StudentModel saveStudent(StudentModel student) {
        student.setCreationDate(LocalDateTime.now());
        student.setLastUpdateDate(LocalDateTime.now());
        return studentRepository.save(student);
    }

    @Override
    public StudentModel getOneStudent(UUID studentId) {
        var studentModel = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException(Constants.MESSAGE_ERROR_NOT_FOUND));
        return studentModel;
    }
}
