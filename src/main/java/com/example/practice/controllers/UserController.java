package com.example.practice.controllers;

import com.example.practice.entities.ChangePasswordDto;
import com.example.practice.entities.LoginUserDto;
import com.example.practice.entities.RegisterUserDto;
import com.example.practice.repository.UserRepository;
import com.example.practice.services.CustomUserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost/4200/")
public class UserController {
    private CustomUserDetailService customUserDetailService;
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Validated RegisterUserDto registerRequest) {
        return customUserDetailService.registerUser(registerRequest.mapToUser());
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Validated LoginUserDto loginRequest) {
        System.out.println("Successfully login");
       return customUserDetailService.loginUser(loginRequest.toUser());
    }

    @PostMapping("/changePassword")
    public ResponseEntity<?>changePassword(@RequestBody @Validated ChangePasswordDto passwordRequest){
        return customUserDetailService.changePassword(passwordRequest);
    }
    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUsers(){
       return ResponseEntity.ok(userRepository.findAll());
    }

}
