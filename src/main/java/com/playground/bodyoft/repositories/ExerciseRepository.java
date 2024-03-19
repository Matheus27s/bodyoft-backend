package com.playground.bodyoft.repositories;

import com.playground.bodyoft.models.ExerciseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseModel, UUID>, JpaSpecificationExecutor<ExerciseModel> {

    @Query(value="select * from tb_exercises where assessment_id = :assessmentId", nativeQuery = true)
    List<ExerciseModel> findAllExerciseIntoAssessment(@Param("assessmentId") UUID assessmentId);

    @Query(value="select * from tb_exercises where assessment_id = :assessmentId and exercise_id = :exerciseId", nativeQuery = true)
    Optional<ExerciseModel> findExerciseIntoAssessment(@Param("assessmentId") UUID assessmentId, @Param("exerciseId") UUID exerciseId);

    void deleteAllByAssessmentAssessmentId(UUID AssessmentId);
}
