package kz.teaching_project.entity;

import kz.teaching_project.entity.enums.LessonType;
import kz.teaching_project.entity.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.springframework.boot.autoconfigure.web.ServerProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity


public class Lesson extends AbsLongEntity {

    @Column(nullable = false)
    String name;

    @ManyToOne(fetch = FetchType.EAGER                                                                                                                                                                                                                                                          )
    @JoinColumn(name = "module_id")
    @ToString.Exclude
    Module module;

    @Enumerated(EnumType.STRING)
    LessonType lessonType;

    boolean isForPreview;

    String videoPath;

    @OneToMany(mappedBy = "lesson", orphanRemoval = true)
    @ToString.Exclude
    List<Resource> resources;

    @OneToMany(mappedBy = "lesson", orphanRemoval = true)
    @ToString.Exclude
    List<LessonStatusForUser> lessonStatusForUsers;

    public Lesson(String name, Module module, LessonType lessonType, boolean isForPreview, String videoPath) {
        this.name = name;
        this.module = module;
        this.lessonType = lessonType;
        this.isForPreview = isForPreview;
        this.videoPath = videoPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Lesson that = (Lesson) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
