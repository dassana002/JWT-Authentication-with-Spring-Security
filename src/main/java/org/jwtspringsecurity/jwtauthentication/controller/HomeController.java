package org.jwtspringsecurity.jwtauthentication.controller;

import lombok.RequiredArgsConstructor;
import org.jwtspringsecurity.jwtauthentication.service.JWTService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final JWTService jwtService;

    @GetMapping
    public String home() {
        return "Hello World";
    }

    // Login and Get Token
    @PostMapping("/login")
    public String login() {
        return jwtService.generateToken();
    }

    // Get User name
    @GetMapping("/username")
    public String getUsername(@RequestParam String token) {
        return jwtService.getUsername(token);
    }

}
