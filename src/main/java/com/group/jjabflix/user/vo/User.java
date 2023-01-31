package com.group.jjabflix.user.vo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long userId;
    private String email;
    private String password;
    private String phoneNumber;
    private String name;
    private String birth;
    private UserMembership membership;
    private UserStatus status;

    private String cardNumber;
    private String cardExpirationDate;

    private LocalDateTime paidAt;
    private LocalDateTime createdAt;
    private LocalDateTime withdrawAt;

    private Role role;
    private List<String> roles = new ArrayList<>();

    public List<String> getRoles() {
        roles.add(role.name());
        return roles;
    }

}

