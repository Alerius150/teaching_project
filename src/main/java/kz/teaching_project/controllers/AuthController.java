package kz.teaching_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class AuthController {
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

//    @GetMapping("/register")
//    public String getRegisterPage() {
//        return "register";
//    }
}
