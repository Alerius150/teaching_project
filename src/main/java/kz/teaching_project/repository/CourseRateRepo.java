package kz.teaching_project.repository;

import kz.teaching_project.entity.CourseRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRateRepo extends JpaRepository<CourseRate, Long> {
}