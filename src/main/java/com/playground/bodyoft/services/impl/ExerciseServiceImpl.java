package com.playground.bodyoft.services.impl;

import com.playground.bodyoft.models.AssessmentModel;
import com.playground.bodyoft.models.ExerciseModel;
import com.playground.bodyoft.repositories.AssessmentRepository;
import com.playground.bodyoft.repositories.ExerciseRepository;
import com.playground.bodyoft.services.ExerciseService;
import com.playground.bodyoft.services.exceptions.EntityNotFoundException;
import com.playground.bodyoft.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    public AssessmentRepository assessmentRepository;

    @Autowired
    public ExerciseRepository exerciseRepository;

    @Override
    @Transactional
    public List<ExerciseModel> saveAllExercises(List<ExerciseModel> exercises, UUID assessmentId) {
        AssessmentModel assessmentModel = assessmentRepository.findById(assessmentId)
                .orElseThrow(() -> new EntityNotFoundException(Constants.MESSAGE_ERROR_NOT_FOUND));
        exercises.forEach(exercise -> exercise.setAssessment(assessmentModel));
        exerciseRepository.saveAll(exercises);
        return exercises;
    }

    @Override
    @Transactional
    public ExerciseModel updateExercise(UUID assessmentId, UUID exerciseId, ExerciseModel exerciseModel) {
        var exerciseModelOptional = exerciseRepository.findExerciseIntoAssessment(assessmentId, exerciseId)
                .orElseThrow(() -> new EntityNotFoundException(Constants.MESSAGE_ERROR_NOT_FOUND));
        exerciseModelOptional.setBodyRegion(exerciseModel.getBodyRegion());
        exerciseModelOptional.setComments(exerciseModel.getComments());
        exerciseModelOptional.setDescriptions(exerciseModel.getDescriptions());
        exerciseModelOptional.setHasDone(exerciseModel.isHasDone());
        exerciseModelOptional.setImageUrl(exerciseModel.getImageUrl());
        exerciseModelOptional.setTrainingDay(exerciseModel.getTrainingDay());

        return exerciseRepository.save(exerciseModelOptional);
    }

    @Override
    @Transactional
    public String deleteExercise(UUID assessmentId, UUID exerciseId) {
        ExerciseModel exerciseModel0 = exerciseRepository.findExerciseIntoAssessment(assessmentId, exerciseId)
                .orElseThrow(() -> new EntityNotFoundException(Constants.MESSAGE_ERROR_NOT_FOUND));
        exerciseRepository.delete(exerciseModel0);
        return(Constants.MESSAGE_ERROR_DELETED_SUCCESSFULLY);
    }

    @Override
    @Transactional
    public String deleteAllExercises(UUID assessmentId) {
        assessmentRepository.findById(assessmentId)
                .orElseThrow(() -> new EntityNotFoundException(Constants.MESSAGE_ERROR_NOT_FOUND));
        exerciseRepository.deleteAllByAssessmentAssessmentId(assessmentId);
        return(Constants.MESSAGE_ERROR_DELETED_SUCCESSFULLY);
    }

    @Override
    public List<ExerciseModel> findAllExerciseByAssessment(UUID assessmentId) {
        return exerciseRepository.findAllExerciseIntoAssessment(assessmentId);
    }

    @Override
    public List<ExerciseModel> findAllExerciseByAssessment(Specification<ExerciseModel> spec) {
        return exerciseRepository.findAll(spec, Sort.by(Sort.Direction.ASC, "groupDay"));
    }

    @Override
    public ExerciseModel findExerciseIntoAssessment(UUID assessmentId, UUID exerciseId) {
        var exerciseModel0 = exerciseRepository.findExerciseIntoAssessment(assessmentId, exerciseId)
                .orElseThrow(() -> new EntityNotFoundException(Constants.MESSAGE_ERROR_NOT_FOUND));
        return exerciseModel0;
    }
}
