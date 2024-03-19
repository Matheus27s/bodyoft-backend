package com.playground.bodyoft.controllers;

import com.playground.bodyoft.Dtos.ExerciseResponsetDTO;
import com.playground.bodyoft.models.ExerciseModel;
import com.playground.bodyoft.services.ExerciseService;
import com.playground.bodyoft.specifications.SpecificationTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExerciseController {

    @Autowired
    public ExerciseService exerciseService;

    @PostMapping("/assessments/{assessmentId}/exercises")
    public ResponseEntity<List<ExerciseModel>> saveAllExercises(
            @RequestBody List<ExerciseModel> exercises,
            @PathVariable(value="assessmentId") UUID assessmentId
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(exerciseService.saveAllExercises(exercises, assessmentId));
    }

    @PutMapping("/assessments/{assessmentId}/exercises/{exerciseId}")
    public ResponseEntity<ExerciseResponsetDTO> updateExercise(
            @PathVariable(value="assessmentId") UUID assessmentId,
            @PathVariable(value="exerciseId") UUID exerciseId,
            @RequestBody ExerciseModel exerciseModel
    ) {
        return new ResponseEntity(exerciseService.updateExercise(assessmentId, exerciseId, exerciseModel), HttpStatus.OK);
    }

    @GetMapping("/assessments/{assessmentId}/exercises")
    public ResponseEntity<List<ExerciseModel>> getAllExercises(
            SpecificationTemplate.ExerciseSpec spec,
            @PathVariable(value="assessmentId") UUID assessmentId
    ) {
        return new ResponseEntity(exerciseService.findAllExerciseByAssessment(SpecificationTemplate.exerciseAssessmentId(assessmentId).and(spec)), HttpStatus.OK);
    }

    @GetMapping("/assessments/{assessmentId}/exercises/{exerciseId}")
    public ResponseEntity<ExerciseModel> getOneExercise(
            @PathVariable(value="assessmentId") UUID assessmentId,
            @PathVariable(value="exerciseId") UUID exerciseId
    ) {
        return new ResponseEntity(exerciseService.findExerciseIntoAssessment(assessmentId, exerciseId), HttpStatus.OK);
    }

    @DeleteMapping("/assessments/{assessmentId}/exercises/{exerciseId}")
    public ResponseEntity deleteExercise(
            @PathVariable(value="assessmentId") UUID assessmentId,
            @PathVariable(value="exerciseId") UUID exerciseId
    ) {
        return new ResponseEntity(exerciseService.deleteExercise(assessmentId, exerciseId), HttpStatus.OK);
    }

    @DeleteMapping("/assessments/{assessmentId}/exercises")
    public ResponseEntity deleteAllExercises(
            @PathVariable(value="assessmentId") UUID assessmentId
        ) {
        return new ResponseEntity(exerciseService.deleteAllExercises(assessmentId), HttpStatus.OK);
    }
}
