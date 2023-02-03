package com.group.jjabflix.config.security;

import com.group.jjabflix.user.dao.UserMapper;
import com.group.jjabflix.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        UserDto user = userMapper.findByUserEmail(email);
        user.setRoles();
        return new CustomUserDetails(user);
    }
}
