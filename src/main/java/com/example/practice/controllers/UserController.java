package com.example.practice.controllers;

import com.example.practice.entities.ChangePasswordDto;
import com.example.practice.entities.LoginUserDto;
import com.example.practice.entities.RegisterUserDto;
import com.example.practice.services.CustomUserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private CustomUserDetailService customUserDetailService;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Validated RegisterUserDto registerRequest) {
        return customUserDetailService.registerUser(registerRequest.mapToUser());
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Validated LoginUserDto loginRequest) {
       return customUserDetailService.loginUser(loginRequest.toUser());
    }

    @PostMapping("/changePassword")
    public ResponseEntity<?>changePassword(@RequestBody @Validated ChangePasswordDto passwordRequest){
        return customUserDetailService.changePassword(passwordRequest);
    }



}
