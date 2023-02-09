package com.group.jjabflix.user.service;

import com.group.jjabflix.user.dao.UserMapper;
import com.group.jjabflix.user.dto.UserSignupRequestDto;
import com.group.jjabflix.user.vo.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void signup(UserSignupRequestDto requestDto) throws Exception {
        if (userMapper.selectUserByEmail(requestDto.getEmail()) != null) {
            throw new Exception("이미 존재하는 이메일입니다");
        }

        User user = requestDto.toUser();
        user.encodePassword(passwordEncoder);

        userMapper.insertUser(user);
    }


}
