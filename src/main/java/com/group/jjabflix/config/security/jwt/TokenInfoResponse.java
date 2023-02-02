package com.group.jjabflix.config.security.jwt;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TokenInfoResponse {

    private String grantType;
    private String accessToken;
    private Long accessTokenExpirationTime;

}
