package com.group.jjabflix.user.service;

import com.group.jjabflix.common.response.ApiResponse;
import com.group.jjabflix.config.security.jwt.TokenInfo;
import com.group.jjabflix.user.dto.UserLoginRequest;
import com.group.jjabflix.user.dto.UserDto;
import com.group.jjabflix.user.dto.UserJoinMembershipRequest;
import com.group.jjabflix.user.dto.UserSignupRequest;

public interface UserService {

    UserDto getUserByEmail(String email);

    TokenInfo login(UserLoginRequest userLoginRequest);

    ApiResponse userSignup(UserSignupRequest user);
    ApiResponse userJoinMembership(UserJoinMembershipRequest user);

}
