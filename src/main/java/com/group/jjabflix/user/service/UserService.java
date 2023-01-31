package com.group.jjabflix.user.service;

import com.group.jjabflix.config.security.jwt.TokenInfo;
import com.group.jjabflix.user.dto.UserLoginRequest;
import com.group.jjabflix.user.vo.User;

public interface UserService {

    User getUserByEmail(String email);

    TokenInfo login(UserLoginRequest userLoginRequest);

}
