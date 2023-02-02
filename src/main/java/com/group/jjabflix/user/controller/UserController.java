package com.group.jjabflix.user.controller;

import com.group.jjabflix.common.response.ApiResponse;
import com.group.jjabflix.config.security.jwt.TokenInfoResponse;
import com.group.jjabflix.user.dto.UserLoginRequest;
import com.group.jjabflix.user.dto.UserJoinMembershipRequest;
import com.group.jjabflix.user.dto.UserSignupRequest;
import com.group.jjabflix.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/auth/login")
    public ApiResponse login(@RequestBody UserLoginRequest userLoginRequest) {
        return userService.login(userLoginRequest);
    }

    @PostMapping("/test") // JWT 테스트
    public String test() {
        return "success";
    }

    @PostMapping("/auth/signup")
    public ApiResponse signup(@RequestBody UserSignupRequest user) {
        return userService.userSignup(user);
    }
    @PostMapping("/auth/signup/membership")
    public ApiResponse signupMembership(@RequestBody UserJoinMembershipRequest user) {
        return userService.userJoinMembership(user);
    }

    @PostMapping("/logout")
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
