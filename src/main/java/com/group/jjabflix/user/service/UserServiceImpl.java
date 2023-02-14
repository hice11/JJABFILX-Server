package com.group.jjabflix.user.service;

import com.group.jjabflix.config.security.jwt.JwtProvider;
import com.group.jjabflix.config.security.jwt.TokenInfoResponse;
import com.group.jjabflix.error.ErrorCode;
import com.group.jjabflix.user.dao.UserMapper;
import com.group.jjabflix.user.dto.UserLoginRequestDto;
import com.group.jjabflix.user.dto.UserSignupRequestDto;
import com.group.jjabflix.user.exception.EmailDuplicationException;
import com.group.jjabflix.user.exception.NotFoundUserException;
import com.group.jjabflix.user.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtProvider jwtProvider;

    @Transactional
    @Override
    public void signup(UserSignupRequestDto requestDto) throws Exception {
        if (userMapper.selectUserByEmail(requestDto.getEmail()) != null) {
            throw new EmailDuplicationException(ErrorCode.EMAIL_DUPLICATION);
        }

        User user = requestDto.toUser();
        user.encodePassword(passwordEncoder);

        userMapper.insertUser(user);
    }

    @Transactional
    @Override
    public ResponseEntity<TokenInfoResponse> login(UserLoginRequestDto requestDto)
        throws Exception {
        if (userMapper.selectUserByEmail(requestDto.getEmail()) == null) {
            throw new NotFoundUserException(ErrorCode.NOT_FOUND_USER);
        }

        UsernamePasswordAuthenticationToken authenticationToken
            = new UsernamePasswordAuthenticationToken(requestDto.getEmail(),
            requestDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject()
            .authenticate(authenticationToken);

        TokenInfoResponse tokenInfoResponse = jwtProvider.generateToken(authentication);

        return ResponseEntity.status(HttpStatus.OK).body(tokenInfoResponse);
    }

}
