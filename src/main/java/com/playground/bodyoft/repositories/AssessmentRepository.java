package com.playground.bodyoft.repositories;

import com.playground.bodyoft.models.AssessmentModel;
import com.playground.bodyoft.models.ExerciseModel;
import com.playground.bodyoft.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AssessmentRepository extends JpaRepository<AssessmentModel, UUID>, JpaSpecificationExecutor<AssessmentModel> {
    @Query(value="select * from tb_assessments where student_id = :studentId and valuation_date = :valuationDate and due_date = :dueDate", nativeQuery = true)
    List<AssessmentModel> findAllAssessmentsIntoStudent(@Param("studentId") UUID studentId);
}
