package com.playground.bodyoft.services;

import com.playground.bodyoft.models.AssessmentModel;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface AssessmentService {
    AssessmentModel saveAssessment(UUID studentId, AssessmentModel assessmentModel);
    List<AssessmentModel> findAllAssessmentsByStudentId(UUID studentId);
    List<AssessmentModel> findAllAssessmentByStudent(Specification<AssessmentModel> spec);
}
