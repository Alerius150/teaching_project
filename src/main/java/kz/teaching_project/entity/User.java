package kz.teaching_project.entity;


import kz.teaching_project.entity.template.AbsUUIDEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "users")

public class User extends AbsUUIDEntity implements UserDetails {


    @Column(nullable = false)
    private String fullName;


    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String password;


    String headLine;

    String biography;

    Integer avgRating;

    Integer numberOfReviews;

    Integer numberOfStudents;


    String phoneNumber;


    String profilePhoto;

//    @ManyToMany
//    @ToString.Exclude
//    Set<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))

    private Collection<Role> roles;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    @ToString.Exclude
    List<CourseRate> courseRates;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    @ToString.Exclude
    List<LessonStatusForUser> lessonStatusForUsers;

    public User(String fullName, String email, String password, String headLine, String biography, String phoneNumber) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.headLine = headLine;
        this.biography = biography;
        this.phoneNumber = phoneNumber;

    }

    public User(String fullName, String email, String password, Collection<Role> roles) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<GrantedAuthority> authorities = new HashSet<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return authorities;
    }


    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
