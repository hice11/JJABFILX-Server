package com.group.jjabflix.profile.service;

import com.group.jjabflix.profile.dto.ProfileRequestDto;
import com.group.jjabflix.profile.vo.Profile;
import org.springframework.http.ResponseEntity;

public interface ProfileService {

    ResponseEntity<Profile> createProfile(ProfileRequestDto profile);

}
