package com.group.jjabflix.config.security;

import com.group.jjabflix.user.dao.UserMapper;
import com.group.jjabflix.user.vo.User;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String email)
        throws UsernameNotFoundException {
        User user = userMapper.selectUserByEmail(email);

        return new CustomUserDetails(user);
    }
}
