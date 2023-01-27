package com.group.jjabflix.user.service;

import com.group.jjabflix.user.dao.UserMapper;
import com.group.jjabflix.user.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public User getUserByEmail(String email) {
        User user = userMapper.findUserByEmail(email);
        return user;
    }
}
