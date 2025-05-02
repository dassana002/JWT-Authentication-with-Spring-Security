package org.jwtspringsecurity.jwtauthentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String home() {
        return "Hello World";
    }

    @PostMapping("/login")
    public String login() {
        return "user log in";
    }
}
