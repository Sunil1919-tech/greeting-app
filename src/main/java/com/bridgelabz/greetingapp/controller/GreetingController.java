package com.bridgelabz.greetingapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping(value = "/greet")
    public String getMessage() {
        return "Hello from BridgeLabz";
    }
}
