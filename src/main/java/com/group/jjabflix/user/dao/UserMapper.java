package com.group.jjabflix.user.dao;

import com.group.jjabflix.user.vo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void insertUser(User user) throws Exception;
    User selectUserByEmail(String email) throws Exception;
}
