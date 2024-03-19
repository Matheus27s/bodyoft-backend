package com.playground.bodyoft.controllers;

import com.playground.bodyoft.models.AssessmentModel;
import com.playground.bodyoft.services.AssessmentService;
import com.playground.bodyoft.specifications.SpecificationTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AssessmentController {

    @Autowired
    AssessmentService assessmentService;

    @PostMapping("students/{studentId}/assessments")
    public ResponseEntity<AssessmentModel> saveAssessment(@RequestBody AssessmentModel assessmentModel, @PathVariable(value="studentId") UUID studentId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(assessmentService.saveAssessment(studentId, assessmentModel));
    }

    @GetMapping("students/{studentId}/assessments")
    public ResponseEntity<List<AssessmentModel>> getAssessments(@PathVariable(value="studentId") UUID studentId, SpecificationTemplate.AssessmentSpec spec) {
        return new ResponseEntity(assessmentService.findAllAssessmentByStudent(SpecificationTemplate.assessmentStudentId(studentId).and(spec)), HttpStatus.OK);

    }
}
