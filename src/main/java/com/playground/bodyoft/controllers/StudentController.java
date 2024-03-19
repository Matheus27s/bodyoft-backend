package com.playground.bodyoft.controllers;

import com.playground.bodyoft.models.ExerciseModel;
import com.playground.bodyoft.models.StudentModel;
import com.playground.bodyoft.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StudentController {

    @Autowired
    public StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentModel> saveStudent(@RequestBody StudentModel studentModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(studentModel));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentModel> getOneStudent(
            @PathVariable(value="studentId") UUID studentId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getOneStudent(studentId));
    }
}
