package com.playground.bodyoft.services.impl;

import com.playground.bodyoft.models.AssessmentModel;
import com.playground.bodyoft.models.StudentModel;
import com.playground.bodyoft.repositories.AssessmentRepository;
import com.playground.bodyoft.repositories.StudentRepository;
import com.playground.bodyoft.services.AssessmentService;
import com.playground.bodyoft.services.exceptions.EntityNotFoundException;
import com.playground.bodyoft.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    @Autowired
    AssessmentRepository assessmentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public AssessmentModel saveAssessment(UUID studentId, AssessmentModel assessment) {
        StudentModel student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException(Constants.MESSAGE_ERROR_NOT_FOUND));

        assessment.setStudent(student);
        return assessmentRepository.save(assessment);
    }

    @Override
    public List<AssessmentModel> findAllAssessmentsByStudentId(UUID studentId) {
        return assessmentRepository.findAllAssessmentsIntoStudent(studentId);
    }

    @Override
    public List<AssessmentModel> findAllAssessmentByStudent(Specification<AssessmentModel> spec) {
        return assessmentRepository.findAll(spec);
    }
}
