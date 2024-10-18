package kz.teaching_project.entity;

import kz.teaching_project.entity.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class PayType extends AbsLongEntity {

    @Column(nullable = false, unique = true)
    String name;

    String logo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PayType payType = (PayType) o;
        return getId() != null && Objects.equals(getId(), payType.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
