package com.group.jjabflix.profile.service;

import com.group.jjabflix.profile.dao.ProfileMapper;
import com.group.jjabflix.profile.dto.ProfileRequestDto;
import com.group.jjabflix.profile.exception.ExistProfileNameException;
import com.group.jjabflix.profile.exception.ProfileOutOfRangeException;
import com.group.jjabflix.profile.vo.Profile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProfileServiceImplTest {

    @InjectMocks
    private ProfileServiceImpl profileService;

    @Mock
    private ProfileMapper profileMapper;

    private ProfileRequestDto profile = new ProfileRequestDto(33L,"하이","img");
    private List<Profile> profileList(int num) {
        List<Profile> profiles = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            profiles.add(new Profile(10L,33L,"1번","img"));
        }
        return profiles;
    }

    @Test
    @DisplayName(value = "프로필 생성 테스트 - service")
    void createProfile() {
        // given
        when(profileMapper.selectProfiles(profile.getUserId())).thenReturn(profileList(1));
        when(profileMapper.isProfileNameExist(profile)).thenReturn(0);
        when(profileMapper.getProfileId(profile)).thenReturn(20L);
        when(profileMapper.selectProfile(20L))
                .thenReturn(new Profile(20L,33L,"하이","img"));
        // when
        ResponseEntity<Profile> response = profileService.createProfile(profile);
        // then
        assertThat(response.getBody().getName()).isEqualTo(profile.getName());
    }

    @Test
    @DisplayName(value = "프로필 개수 제한 예외 테스트 - service")
    void profileRangeException() {
        // given
        when(profileMapper.selectProfiles(profile.getUserId())).thenReturn(profileList(5));
        // when
        // then
        assertThatExceptionOfType(ProfileOutOfRangeException.class).isThrownBy(() -> {
            profileService.createProfile(profile);
        });
    }

    @Test
    @DisplayName(value = "프로필 이름 즁복 예외 테스트 - service")
    void existProfileNameException() {
        // given
        when(profileMapper.selectProfiles(profile.getUserId())).thenReturn(profileList(1));
        when(profileMapper.isProfileNameExist(profile)).thenReturn(1);
        // when
        // then
        assertThatExceptionOfType(ExistProfileNameException.class).isThrownBy(() -> {
            profileService.createProfile(profile);
        });
    }

}