package com.group.jjabflix.user.dao;

import com.group.jjabflix.user.dto.UserDto;
import com.group.jjabflix.user.dto.UserJoinMembershipRequest;
import com.group.jjabflix.user.dto.UserSignupRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserDto findByUserEmail(String email);

    void createUser(UserSignupRequest user);
    void createUserMembership(UserJoinMembershipRequest user);

}
