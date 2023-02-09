package com.group.jjabflix.user.service;

import com.group.jjabflix.user.dto.UserSignupRequestDto;

public interface UserService {

    void signup(UserSignupRequestDto requestDto) throws Exception;

}