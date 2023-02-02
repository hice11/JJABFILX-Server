package com.group.jjabflix.user.dto;

import com.group.jjabflix.user.vo.UserMembership;
import com.group.jjabflix.user.vo.UserRole;
import com.group.jjabflix.user.vo.UserStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

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

    private UserRole role;
    private List<String> roles = new ArrayList<>();

    public void setRoles() {
        roles.add(role.name());
    }

}

