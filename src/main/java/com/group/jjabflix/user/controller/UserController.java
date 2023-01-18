package com.group.jjabflix.user.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @PostMapping("/login")
    public void login() {

    }

    @PostMapping
    public void addUser() {

    }

    @GetMapping("/{userId}")
    public void getUser(@PathVariable Long userId) {

    }

    @PostMapping("/email")
    public void findUserPassword() {

    }

    @PutMapping("/{userId}")
    public void editUser(@PathVariable Long userId) {

    }

    @DeleteMapping("/{userId}")
    public void withdrawUser(@PathVariable Long userId) {

    }
}
