package com.group.jjabflix.user.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserSignupRequest {

    private String email;
    private String password;

}
