package kz.teaching_project.entity;

import kz.teaching_project.entity.enums.PaymentStatus;
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
public class PurchaseHistory extends AbsLongEntity {

    double totalAmount;

    @ManyToMany
    @JoinTable(
            name = "payment_histories_courses",
            joinColumns = @JoinColumn(name = "purchase_history_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @ToString.Exclude
    List<Course> courseList;


    @Enumerated(EnumType.STRING)
    PaymentStatus paymentStatus;

    boolean idRefunded;

    String stripePaymentIntent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PurchaseHistory that = (PurchaseHistory) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
