package com.group.jjabflix.wish.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wishes")
public class WishController {

    @PostMapping
    public void addWish() {

    }

    @GetMapping("/{profileId}")
    public void findWishList() {

    }

    @DeleteMapping("/{wishId}")
    public void cancelWish(@PathVariable long wishId) {

    }

}
