package com.group.jjabflix.user.controller;

import com.group.jjabflix.common.response.ApiResponse;
import com.group.jjabflix.config.security.jwt.TokenInfo;
import com.group.jjabflix.user.dto.UserDto;
import com.group.jjabflix.user.dto.UserLoginRequest;
import com.group.jjabflix.user.dto.UserSignup2Request;
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
    public TokenInfo login(@RequestBody UserLoginRequest userLoginRequest) {
        TokenInfo tokenInfo = userService.login(userLoginRequest);
        return tokenInfo;
        //return userService.getUserByEmail(userLoginRequest.getEmail());
    }

    @PostMapping("/test") // JWT 테스트
    public String test() {
        return "success";
    }

    @PostMapping("/auth/signup")
    public ApiResponse<UserDto> signup(@RequestBody UserSignupRequest user) {
        return userService.userJoin1(user);
    }
    @PostMapping("/auth/signup2")
    public ApiResponse<UserDto> signup2(@RequestBody UserSignup2Request user) {
        return userService.userJoin2(user);
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
