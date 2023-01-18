package com.group.jjabflix.content.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/contents")
public class ContentController {

    @GetMapping
    public void getContents() {

    }

    @GetMapping("/{genre}")
    public void getContentsByGenre(@PathVariable String genre) {

    }

    @GetMapping("/{contentId}")
    public void getContentById(@PathVariable long contentId) {

    }

}
