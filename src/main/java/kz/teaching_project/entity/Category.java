package kz.teaching_project.entity;

import kz.teaching_project.entity.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

import static kz.teaching_project.service.UtilFunctions.getUniquePathName;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity


public class Category extends AbsLongEntity {
    @Column(nullable = false)
    String name;

    @Column(nullable = false,unique = true)
    String pathName;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "parent_id")
//    @ToString.Exclude
//    Category parent;


    public Category(String name) {
        this.name = name;
        this.pathName = getUniquePathName(name);
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Category category = (Category) o;
        return getId() != null && Objects.equals(getId(), category.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}