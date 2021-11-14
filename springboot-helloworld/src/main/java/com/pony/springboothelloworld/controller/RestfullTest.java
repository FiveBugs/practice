package com.pony.springboothelloworld.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class RestfullTest {

    @GetMapping("/user")
    public String getUser() {
        return "get user";
    }

    @PutMapping("/user")
    public String putUser() {
        return "pub user";
    }

    @PostMapping("/user")
    public String postUser() {
        return "post user";
    }

    @DeleteMapping("/user")
    public String deleteUser() {
        return "delete user";
    }
}
