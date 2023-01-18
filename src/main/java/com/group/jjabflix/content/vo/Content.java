package com.group.jjabflix.content.vo;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Content {

    private long contentId;
    private String genre;
    private String title;
    private String overview;
    private int seasonNumber;
    private int episodeNumber;
    private int runTime;
    private LocalDate releasedAt;
    private String posterPath;
    private String backdropPath;

}
