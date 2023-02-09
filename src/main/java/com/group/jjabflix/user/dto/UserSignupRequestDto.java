package com.group.jjabflix.user.dto;

import com.group.jjabflix.user.vo.Role;
import com.group.jjabflix.user.vo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserSignupRequestDto {

    private String email;
    private String password;
    private String phoneNumber;
    private String name;
    private String birth;

    private Role role;

    public User toUser() {
        return new User(
            email, password, phoneNumber, name, birth, Role.ROLE_USER
        );
    }

}
