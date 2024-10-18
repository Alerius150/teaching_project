package kz.teaching_project.repository;

import kz.teaching_project.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepo extends JpaRepository<Answer, Long> {
}
