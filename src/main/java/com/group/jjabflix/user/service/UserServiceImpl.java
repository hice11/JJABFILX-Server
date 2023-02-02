package com.group.jjabflix.user.service;

import com.group.jjabflix.common.response.ApiResponse;
import com.group.jjabflix.common.response.Result;
import com.group.jjabflix.config.security.jwt.JwtProvider;
import com.group.jjabflix.config.security.jwt.TokenInfo;
import com.group.jjabflix.user.dao.UserMapper;
import com.group.jjabflix.user.dto.UserLoginRequest;
import com.group.jjabflix.user.dto.UserDto;
import com.group.jjabflix.user.dto.UserJoinMembershipRequest;
import com.group.jjabflix.user.dto.UserSignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto getUserByEmail(String email) {
        return userMapper.findByUserEmail(email);
    }

    @Override
    public TokenInfo login(UserLoginRequest userLoginRequest) {
        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(userLoginRequest.getEmail(), userLoginRequest.getPassword());

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = jwtProvider.generateToken(authentication);

        return tokenInfo;
    }

    @Override
    public ApiResponse userSignup(UserSignupRequest user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.createUser(user);
        //
        UserDto userDto = userMapper.findByUserEmail(user.getEmail());
        Result result = new Result() { private UserDto user = userDto; public UserDto getUser() {return user;} };
        return ApiResponse.ok(result);
    }

    @Override
    public ApiResponse userJoinMembership(UserJoinMembershipRequest user) {
        userMapper.createUserMembership(user);
        //
        UserDto userDto = userMapper.findByUserEmail(user.getEmail());
        Result result = new Result() { private UserDto user = userDto; public UserDto getUser() {return user;} };
        return ApiResponse.ok(result);
    }
}
