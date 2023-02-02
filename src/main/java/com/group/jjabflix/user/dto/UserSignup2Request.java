package com.group.jjabflix.user.dto;

import com.group.jjabflix.user.vo.UserMembership;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserSignup2Request {

    private String email;

    private String phoneNumber;
    private String name;
    private String birth;
    private UserMembership membership;

    private String cardNumber;
    private String cardExpirationDate;

}
