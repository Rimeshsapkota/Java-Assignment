package com.example.practice.controllers;

import com.example.practice.entities.RegisterUserDto;
import com.example.practice.services.CustomUserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebpageController {

    @GetMapping("/")
    public String showFrontPage() {
        return "index";
    }
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }
}
