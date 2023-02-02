package com.group.jjabflix.user.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {

    private String email;
    private String password;

}
