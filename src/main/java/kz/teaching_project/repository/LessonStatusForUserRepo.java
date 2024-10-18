package kz.teaching_project.repository;

import kz.teaching_project.entity.LessonStatusForUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonStatusForUserRepo extends JpaRepository<LessonStatusForUser, Long> {
}
