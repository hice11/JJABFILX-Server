package com.group.jjabflix.user.dao;

import com.group.jjabflix.user.dto.UserDto;
import com.group.jjabflix.user.dto.UserSignup2Request;
import com.group.jjabflix.user.dto.UserSignupRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserDto findByUserEmail(String email);

    void createUser1(UserSignupRequest user);
    void createUser2(UserSignup2Request user);

}
