package kz.teaching_project.entity;


import kz.teaching_project.entity.enums.CourseStatus;
import kz.teaching_project.entity.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

import static kz.teaching_project.service.UtilFunctions.getUniquePathName;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Course extends AbsLongEntity {
    @Column(nullable = false)
    String name;

    @Column(unique = true)
    String pathName ;

    @Column(nullable = false)
    Double price;

    @ManyToMany
    @ToString.Exclude
    List<User> instructors;

    @Column(nullable = false)
    String headline;


    String courseImage;

    @Column(nullable = false, columnDefinition = "text")

    String description;

    //    @Column(nullable = false)
    String language;


    Float avgRating;

    @Column(nullable = false, columnDefinition = "text")
    String learningSkills;

    @Column(nullable = false, columnDefinition = "text")
    String requirements;




    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @Enumerated(EnumType.STRING)
    CourseStatus status;

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    @ToString.Exclude
    List<Module> modules;

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    @ToString.Exclude
    List<CourseRate> courseRates;


    public Course(String name, Double price, List<User> instructors, String headline,
                  String description, String learningSkills, String requirements, Category category) {
        this.name = name;
        this.price = price;
        this.instructors = instructors;
        this.headline = headline;
        this.description = description;
        this.learningSkills = learningSkills;
        this.requirements = requirements;
        this.category = category;
        this.pathName = getUniquePathName(name);
    }


    public Course(String name, Double price, List<User> instructors, String headline,
                  String courseImage, String description, String learningSkills, String requirements,Category category) {
        this.name = name;
        this.price = price;
        this.instructors = instructors;
        this.headline = headline;
        this.courseImage = courseImage;
        this.description = description;
        this.learningSkills = learningSkills;
        this.requirements = requirements;
        this.category = category;
        this.pathName = getUniquePathName(name);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Course courses = (Course) o;
        return getId() != null && Objects.equals(getId(), courses.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
