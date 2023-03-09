package com.group.jjabflix.profile.dao;

import com.group.jjabflix.profile.dto.ProfileRequestDto;
import com.group.jjabflix.profile.vo.Profile;
import com.group.jjabflix.user.dao.UserMapper;
import com.group.jjabflix.user.vo.Role;
import com.group.jjabflix.user.vo.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProfileMapperTest {

    @Autowired
    private ProfileMapper profileMapper;
    @Autowired
    private UserMapper userMapper;

    Long userId = 0L;
    Long profileId = 0L;

    @BeforeEach
    void beforeEach() throws Exception {
        // user 추가
        String email = "test11@test.com";
        User user = User.builder()
                .email(email).password("1234").phoneNumber("010-0000-0000")
                .name("테스트").birth("1999-09-09").role(Role.ROLE_USER)
                .build();
        userMapper.insertUser(user);
        userId = userMapper.selectUserByEmail(email).getUserId();
        // user 에 프로필 추가
        ProfileRequestDto profile = new ProfileRequestDto(userId,"1번","img");
        profileMapper.insertProfile(profile);
        profileId = profileMapper.getProfileId(profile);
    }

    @Test
    @DisplayName(value = "프로필 생성 & profileId 얻기 & 상세 조회 테스트 - mapper")
    void insertProfile() {
        // given
        ProfileRequestDto profile = new ProfileRequestDto(userId,"하이","img");
        // when
        profileMapper.insertProfile(profile);
        // then
        Profile result = profileMapper.selectProfile(profileMapper.getProfileId(profile));
        assertThat(result.getUserId()).isEqualTo(profile.getUserId());
        assertThat(result.getName()).isEqualTo(profile.getName());
    }

    @Test
    @DisplayName(value = "프로필 상세 조회 테스트 - mapper")
    void selectProfile() {
        // given
        // when
        Profile result = profileMapper.selectProfile(profileId);
        // then
        assertThat(result.getName()).isEqualTo("1번");
    }

    @Test
    @DisplayName(value = "프로필 목록 조회 테스트 - mapper")
    void selectProfiles() {
        // given
        // when
        List<Profile> result = profileMapper.selectProfiles(userId);
        // then
        assertThat(result.get(0).getName()).isEqualTo("1번");
    }

    @Test
    @DisplayName(value = "프로필 이름 중복 확인 테스트 - mapper")
    void isProfileNameExist() {
        // given
        ProfileRequestDto profile = new ProfileRequestDto(userId,"1번","img");
        // when
        int result = profileMapper.isProfileNameExist(profile);
        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName(value = "프로필 id 얻기 테스트 - mapper")
    void getProfileId() {
        // given
        ProfileRequestDto profile = new ProfileRequestDto(userId,"1번",null);
        // when
        Long profileIdTest = profileMapper.getProfileId(profile);
        // then
        assertThat(profileIdTest).isEqualTo(profileId);
    }

}