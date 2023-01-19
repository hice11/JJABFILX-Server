package com.group.jjabflix.profile.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    @PostMapping
    public void addProfile() {

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
