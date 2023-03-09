package com.group.jjabflix.profile.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.w3c.dom.Text;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    private Long profileId;
    private Long userId;
    private String name;
    private String icon;
}
