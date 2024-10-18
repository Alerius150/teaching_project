package kz.teaching_project.entity;

import kz.teaching_project.entity.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

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


public class Question extends AbsLongEntity {

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String body;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    Lesson lesson;

    int reputation;

    @OneToMany(mappedBy = "question", orphanRemoval = true)
    @ToString.Exclude
    List<Answer> answers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Question that = (Question) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
