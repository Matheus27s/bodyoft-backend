package com.playground.bodyoft.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="TB_EXERCISES")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExerciseModel implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name="exercise_id")
   private UUID exerciseId;

   @Column(length=15000)
   private String imageUrl;
   private String bodyRegion;
   private String descriptions;
   @Column(length=2000)
   private String comments;
   private String trainingDay;
   private boolean hasDone;
   private String videoId;
   private String groupDay;

   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   @ManyToOne(optional = false, fetch = FetchType.LAZY)
   @JoinColumn(name = "assessment_id")
   private AssessmentModel assessment;
}
