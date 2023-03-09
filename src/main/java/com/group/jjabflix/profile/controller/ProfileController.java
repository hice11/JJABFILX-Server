package com.group.jjabflix.profile.controller;

import com.group.jjabflix.profile.dto.ProfileRequestDto;
import com.group.jjabflix.profile.service.ProfileService;
import com.group.jjabflix.profile.vo.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping
    public ResponseEntity<Profile> addProfile(@RequestBody ProfileRequestDto profile) {
        return profileService.createProfile(profile);
    }

    @GetMapping("/{userId}")
    public void getProfileList() {

    }

    @GetMapping("/{profileId}")
    public void getProfile(@PathVariable Long profileId) {

    }

    @PutMapping("/{profileId}")
    public void editProfile(@PathVariable Long profileId) {

    }

    @DeleteMapping("/{profileId}")
    public void removeProfile(@PathVariable Long profileId) {

    }
}
