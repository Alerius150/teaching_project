package kz.teaching_project.repository;

import kz.teaching_project.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findByName(String name);

    Category findByPathName(String pathName);

}