package com.group.jjabflix.like.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Like {

    private long likeId;
    private long profileId;
    private long contentId;
    private LocalDateTime createdAt;

}
