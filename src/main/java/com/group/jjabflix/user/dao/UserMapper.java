package com.group.jjabflix.user.dao;

import com.group.jjabflix.user.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {

    User findByUserEmail(String email);

}
