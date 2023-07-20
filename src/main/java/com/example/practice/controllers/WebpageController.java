package com.example.practice.controllers;

import com.example.practice.entities.LoginUserDto;
import com.example.practice.entities.RegisterUserDto;
import com.example.practice.entities.User;
import com.example.practice.services.CustomUserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class WebpageController {
private CustomUserDetailService service;
    @GetMapping("/")
    public String showFrontPage() {
        return "index";
    }
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

   @PostMapping("/register")
    public String saveStudent(@ModelAttribute("user") RegisterUserDto registerUserDto) {
        service.registerUser(registerUserDto.mapToUser());
        return "save";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") LoginUserDto loginUserDto) {
        service.registerUser(loginUserDto.toUser());
        return "login";
    }

}
