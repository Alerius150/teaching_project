package kz.teaching_project.controllers;

import kz.teaching_project.dto.UserRegistrationDto;
import kz.teaching_project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @RequestBody UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/register";
    }
}