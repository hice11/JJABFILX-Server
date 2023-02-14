package com.group.jjabflix.user.service;

import com.group.jjabflix.config.security.jwt.TokenInfoResponse;
import com.group.jjabflix.user.dto.UserLoginRequestDto;
import com.group.jjabflix.user.dto.UserSignupRequestDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    void signup(UserSignupRequestDto requestDto) throws Exception;

    ResponseEntity<TokenInfoResponse> login(UserLoginRequestDto requestDto) throws Exception;

}