package com.group.jjabflix.like.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/likes")
public class LikeController {

    @PostMapping
    public void addLike() {

    }

    @DeleteMapping("/{likeId}")
    public void cancelLike(@PathVariable long likeId) {

    }

}
