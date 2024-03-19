package com.playground.bodyoft.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="TB_ASSESSMENTS")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssessmentModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="assessment_id")
    private UUID assessmentId;
    private String valuationDate;
    private String dueDate;
    private String teacher;

    @Embedded
    private PerimetryModel perimetry;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "assessment", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private Set<ExerciseModel> exercises;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentModel student;

}