package com.group.jjabflix.profile.service;

import com.group.jjabflix.profile.dto.ProfileRequestDto;
import com.group.jjabflix.profile.vo.Profile;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProfileService {

    ResponseEntity<Profile> createProfile(ProfileRequestDto profile);

    ResponseEntity<Profile> getProfile(Long profileId);

    ResponseEntity<List<Profile>> getProfiles(Long userId);

}
