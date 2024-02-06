package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class UserController {
    
    private final UserRepository userRepository;

    @PostMapping("/user")
    public ResponseEntity<?> postUser(@RequestBody UserDto dto) {

        User user = User.builder()
            .email(dto.getEmail())
            .userName(dto.getUserName())
            .build();
        
        userRepository.save(user);

        return ResponseEntity.ok().body(user);
    }
    
}
