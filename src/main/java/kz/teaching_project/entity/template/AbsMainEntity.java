package kz.teaching_project.entity.template;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.OrderBy;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString

@MappedSuperclass
@EntityListeners(
        AuditingEntityListener.class)
public abstract class AbsMainEntity {

    @OrderBy
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @CreatedBy
    @Column(name = "created_by_id")
    private UUID createdBy;

    @LastModifiedBy
    @Column(name = "updated_by_id")
    private UUID updatedBy;

    }
