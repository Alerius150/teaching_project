package kz.teaching_project.entity;


import kz.teaching_project.entity.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity


public class Role extends AbsLongEntity {

    @Column(nullable = false)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Role that = (Role) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
