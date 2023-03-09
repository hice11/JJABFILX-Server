package com.group.jjabflix.profile.controller;

import com.google.gson.Gson;
import com.group.jjabflix.profile.dto.ProfileRequestDto;
import com.group.jjabflix.profile.service.ProfileServiceImpl;
import com.group.jjabflix.profile.vo.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProfileControllerTest {

    @InjectMocks
    private ProfileController profileController;

    @Mock
    private ProfileServiceImpl profileService;

    private MockMvc mockMvc;

    @BeforeEach
    void beforeEach() {
        mockMvc = MockMvcBuilders.standaloneSetup(profileController).build();
    }

    @Test
    @DisplayName(value = "프로필 생성 테스트 - controller")
    void addProfile() throws Exception {
        // given
        ProfileRequestDto profileRequest = new ProfileRequestDto(33L,"하이","img");
        Profile profileResponse = new Profile(20L,33L,"4번","img");

        when(profileService.createProfile(any(ProfileRequestDto.class)))
                .thenReturn(ResponseEntity.status(HttpStatus.CREATED).body(profileResponse));

        // when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/profiles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(profileRequest))
        );
        // then
        MvcResult mvcResult = resultActions.andExpect(status().isCreated())
                .andExpect(jsonPath("profileId",profileResponse.getProfileId()).exists())
                .andExpect(jsonPath("userId",profileResponse.getUserId()).exists())
                .andExpect(jsonPath("name",profileResponse.getName()).exists())
                .andExpect(jsonPath("icon",profileResponse.getIcon()).exists())
                .andReturn();
    }

}