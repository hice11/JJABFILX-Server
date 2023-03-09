package com.group.jjabflix.profile.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProfileRequestDto {

    private Long userId;
    private String name;
    private String icon;

}
