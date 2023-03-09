package com.group.jjabflix.profile.service;

import com.group.jjabflix.error.ErrorCode;
import com.group.jjabflix.profile.dao.ProfileMapper;
import com.group.jjabflix.profile.dto.ProfileRequestDto;
import com.group.jjabflix.profile.exception.ExistProfileNameException;
import com.group.jjabflix.profile.exception.ProfileOutOfRangeException;
import com.group.jjabflix.profile.vo.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileMapper profileMapper;

    @Override
    @Transactional
    public ResponseEntity<Profile> createProfile(ProfileRequestDto profile) {
        if (profileMapper.selectProfiles(profile.getUserId()).size() > 4) {
            throw new ProfileOutOfRangeException(ErrorCode.PROFILE_OUT_OF_RANGE);
        }
        if (profileMapper.isProfileNameExist(profile) != 0) {
            throw new ExistProfileNameException(ErrorCode.ALREADY_EXIST_PROFILE_NAME);
        }
        profileMapper.insertProfile(profile);
        Profile profileResponse = profileMapper.selectProfile(profileMapper.getProfileId(profile));
        return ResponseEntity.status(HttpStatus.CREATED).body(profileResponse);
    }

}
