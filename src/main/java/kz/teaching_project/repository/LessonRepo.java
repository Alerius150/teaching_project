package kz.teaching_project.repository;

import kz.teaching_project.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LessonRepo extends JpaRepository<Lesson, Long> {

    List<Lesson> findAllByModuleId(Long module_id);

    Optional<Lesson> findById(Long id);



}