package com.playground.bodyoft.services;

import com.playground.bodyoft.models.ExerciseModel;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface ExerciseService {
    List<ExerciseModel> saveAllExercises(List<ExerciseModel> exercises, UUID studentId);
    ExerciseModel updateExercise(UUID studentId, UUID exerciseId, ExerciseModel exerciseModel);
    String deleteExercise(UUID studentId, UUID exerciseId);
    String deleteAllExercises(UUID studentId);
    List<ExerciseModel> findAllExerciseByAssessment(UUID studentId);
    List<ExerciseModel> findAllExerciseByAssessment(Specification<ExerciseModel> spec);
    ExerciseModel findExerciseIntoAssessment(UUID studentId, UUID exerciseId);
}