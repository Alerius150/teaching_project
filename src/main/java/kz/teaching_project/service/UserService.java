package kz.teaching_project.service;

import kz.teaching_project.dto.UserRegistrationDto;
import kz.teaching_project.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
