package com.playground.bodyoft.Dtos;

import com.playground.bodyoft.enums.TrainingDayEnum;
import com.playground.bodyoft.models.ExerciseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseResponsetDTO {
    private String id;
    private String imageUrl;
    private List<String> descriptions;
    private List<String> comments;
    private String bodyRegion;
    private TrainingDayEnum trainingDay;
    private String reference;
    private String due;

//    public ExerciseModel toModel() {
//        return ExerciseModel
//                .builder()
//                .id(id)
//                .imageUrl(imageUrl)
//                .descriptions(descriptions)
//                .comments(comments)
//                .bodyRegion(bodyRegion)
//                .trainingDay(trainingDay.getValue())
//                .reference(reference)
//                .due(due)
//                .hasDone(false)
//                .build();
//    }
//
//    public static ExerciseResponsetDTO toDto(ExerciseModel exerciseModel) {
//        ExerciseResponsetDTO exerciseResponsetDTO = new ExerciseResponsetDTO();
//        exerciseResponsetDTO.setId(exerciseModel.getId());
//        exerciseResponsetDTO.setBodyRegion(exerciseModel.getBodyRegion());
//        exerciseResponsetDTO.setComments(exerciseModel.getComments());
//        exerciseResponsetDTO.setDescriptions(exerciseModel.getDescriptions());
//        exerciseResponsetDTO.setReference(exerciseModel.getReference());
//        exerciseResponsetDTO.setDue(exerciseModel.getDue());
//        exerciseResponsetDTO.setImageUrl(exerciseModel.getImageUrl());
//        return exerciseResponsetDTO;
//    }
}
