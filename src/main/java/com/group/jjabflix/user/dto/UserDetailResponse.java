package com.group.jjabflix.user.dto;

import com.group.jjabflix.user.vo.UserMembership;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailResponse {

    private String membershipStarDate;
    private String email;
    private String phoneNumber;
    private String cardEndNumber;
    private String nextBillingDate;
    private UserMembership membership;

}
