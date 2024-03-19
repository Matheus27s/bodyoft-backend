package com.playground.bodyoft.specifications;

import com.playground.bodyoft.models.AssessmentModel;
import com.playground.bodyoft.models.ExerciseModel;
import com.playground.bodyoft.models.StudentModel;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collection;
import java.util.UUID;

public class SpecificationTemplate {
    @And({
            @Spec(path = "trainingDay", spec = Equal.class)
    })
    public interface ExerciseSpec extends Specification<ExerciseModel> {}

    public static Specification<ExerciseModel> exerciseAssessmentId(final UUID assessmentId) {
        return (root, query, cb) -> {
            query.distinct(true);
            Root<ExerciseModel> exercise = root;
            Root<AssessmentModel> assessment = query.from(AssessmentModel.class);
            Expression<Collection<ExerciseModel>> assessmentExercicies = assessment.get("exercises");
            return cb.and(cb.equal(assessment.get("assessmentId"), assessmentId), cb.isMember(exercise, assessmentExercicies));
        };
    }

    @And({
            @Spec(path = "dueDate", spec = Equal.class),
            @Spec(path = "valuationDate", spec = Equal.class),
    })
    public interface AssessmentSpec extends Specification<AssessmentModel> {}

    public static Specification<AssessmentModel> assessmentStudentId(final UUID studentId) {
        return (root, query, cb) -> {
            query.distinct(true);
            Root<AssessmentModel> assessment = root;
            Root<StudentModel> student = query.from(StudentModel.class);
            Expression<Collection<AssessmentModel>> studentAssessments = student.get("assessments");
            return cb.and(cb.equal(student.get("studentId"), studentId), cb.isMember(assessment, studentAssessments));
        };
    }
}
