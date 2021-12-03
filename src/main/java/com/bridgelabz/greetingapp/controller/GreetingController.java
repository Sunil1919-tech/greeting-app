package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @GetMapping(value = "/greet")
    public String getGreeting() {
        return "Hello from BridgeLabz";
    }

    @GetMapping(value = "/message")
    public String getGreeting(
            @RequestParam String firstName,
            @RequestParam String lastName
    ) {
        return "Hello" + firstName + " " + lastName;
    }

    @PostMapping(value = "/getGreet")
    public UserDTO userDetails(
            @RequestBody UserDTO userDTO
    ) {
        return userDTO;
    }

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/message1")
    public String getMessage() {
        return greetingService.getMessage();
    }
}
