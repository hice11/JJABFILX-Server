package com.group.jjabflix.user.controller;

import com.group.jjabflix.config.security.jwt.TokenInfoResponse;
import com.group.jjabflix.user.dto.UserLoginRequestDto;
import com.group.jjabflix.user.dto.UserSignupRequestDto;
import com.group.jjabflix.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/login")
    public ResponseEntity<TokenInfoResponse> login(@RequestBody UserLoginRequestDto requestDto)
        throws Exception {
        return userService.login(requestDto);
    }

    @PostMapping("/auth/signup")
    public void signup(@RequestBody UserSignupRequestDto requestDto) throws Exception {
        userService.signup(requestDto);
    }

    @PostMapping("/auth/logout")
    public void logout() {

    }

    @GetMapping("/auth/password")
    public void findPassword() {

    }

    @GetMapping("/users/{userId}")
    public void getUser(@PathVariable Long userId) {

    }

    @PutMapping("/users/{userId}")
    public void editUser(@PathVariable Long userId) {

    }

    @DeleteMapping("/users/{userId}")
    public void withdrawUser(@PathVariable Long userId) {

    }
}
